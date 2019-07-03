package br.ufjf.dcc193.t3.documentos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String descricao;
    private String senha;
    private String email;

    @OneToMany(mappedBy = "criador", cascade = CascadeType.ALL)
    private List<Anotacao> anotacoes;

    public Usuario()
    {

    }
    public Usuario(String nome, String descricao, String senha, String email)
    {
        this.nome = nome;
        this.descricao = descricao;
        this.senha = senha;
        this.email = email;
    }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDescricao()
    {
        return descricao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getSenha()
    {
        return senha;
    }
    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<Anotacao> getAnotacoes()
    {
        return this.anotacoes;
    }
    public void setAnotacoes(List<Anotacao> anotacoes)
    {
        this.anotacoes = anotacoes;
    }

    public Boolean checkAccess(String senha)
    {
        return this.senha.equals(senha);
    }

    @Override
    public String toString() {
        return "Usuario [descricao=" + descricao + ", email=" + email + ", id=" + id + ", nome=" + nome + ", senha="
                + senha + "]";
    }
}