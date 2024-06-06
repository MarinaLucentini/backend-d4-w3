package marinalucentini.entities;

import jakarta.persistence.*;
import marinalucentini.enums.SessoType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Persona {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;

    private String email;
    private LocalDate data_di_nascita;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SessoType sessoType;
    @OneToMany(mappedBy = "partecipazioni")
    private List<Partecipazioni> partecipazioniList;

    public Persona() {

    }


    public Persona(String nome, String cognome, String email, LocalDate data_di_nascita, SessoType sessoType) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_di_nascita = data_di_nascita;
        this.sessoType = sessoType;


    }

    public List<Partecipazioni> getPartecipazioniList() {
        return partecipazioniList;
    }

    public void setPartecipazioniList(List<Partecipazioni> partecipazioniList) {
        this.partecipazioniList = partecipazioniList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public SessoType getSessoType() {
        return sessoType;
    }

    public void setSessoType(SessoType sessoType) {
        this.sessoType = sessoType;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", sessoType=" + sessoType +
                '}';
    }
}
