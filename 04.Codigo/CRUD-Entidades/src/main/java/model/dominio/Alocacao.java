package model.dominio;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

/**
 * Created by cristian on 30/11/16.
 */

@PlanningEntity
@XStreamAlias("Alocacao")
public class Alocacao {

    private Horario horario;
    private Disciplina disciplina;
    private Professor professor;


    public Alocacao() {}

    public Alocacao(Disciplina disciplina, Professor professor) {
        this.setDisciplina(disciplina);
        this.setProfessor(professor);
    }

    public Alocacao(Disciplina subjectParam) {
        setDisciplina(subjectParam);
    }


    @PlanningVariable(valueRangeProviderRefs = {"Horario"})
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario){
        this.horario = horario;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getDisciplina())
                .append(getProfessor())
                .toHashCode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Alocacao) {
            Alocacao other = (Alocacao) o;
            return new EqualsBuilder()
                    .append(getDisciplina(), other.getDisciplina())
                    .append(getProfessor(), other.getProfessor())
                    .isEquals();
        } else {
            return false;
        }
    }
}
