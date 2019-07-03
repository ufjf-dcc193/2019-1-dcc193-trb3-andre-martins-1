package br.ufjf.dcc193.t3.documentos;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Anotacao
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String titulo;
    private String descricao;
    private String url;

    private Date dataCriacao;
    private Date dataAlteracao;

    @ManyToOne
    @JoinColumn
    private Usuario criador;

    @ManyToOne
    @JoinColumn
    private Item item;

    @ManyToOne
    @JoinColumn
    private Vinculo vinculo;

    public Anotacao()
    {
        this.dataCriacao = new Date(System.currentTimeMillis());
        this.dataAlteracao = new Date(System.currentTimeMillis());
    }
    public Anotacao(String titulo, String descricao, String url)
    {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;

        this.dataCriacao = new Date(System.currentTimeMillis());
        this.dataAlteracao = new Date(System.currentTimeMillis());
    }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitulo()
    {
        return titulo;
    }
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getDescricao()
    {
        return descricao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public Date getDataCriacao()
    {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao)
    {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAlteracao()
    {
        return dataAlteracao;
    }
    public void setDataAlteracao(Date dataAlteracao)
    {
        this.dataAlteracao = dataAlteracao;
    }

    public Usuario getCriador()
    {
        return criador;
    }
    public void setCriador(Usuario criador)
    {
        this.criador = criador;
    }

    public Item getItem()
    {
        return item;
    }
    public void setItem(Item item)
    {
        this.item = item;
    }
}