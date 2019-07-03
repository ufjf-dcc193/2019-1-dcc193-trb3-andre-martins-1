package br.ufjf.dcc193.t3.documentos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Etiqueta
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String titulo;
    private String descricao;
    private String url;

    @ManyToMany(mappedBy="etiquetas", cascade = CascadeType.PERSIST)
    private List<Item> itens;

    @ManyToMany(mappedBy="etiquetas", cascade = CascadeType.PERSIST)
    private List<Vinculo> vinculos;

    public Etiqueta()
    {
    }
    public Etiqueta(String titulo, String descricao, String url)
    {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;

        this.itens = new ArrayList<Item>();
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

    public List<Item> getItens()
    {
        return itens;
    }
    public void setItem(List<Item> itens)
    {
        this.itens = itens;
    }
    public void addItem(Item item)
    {
        this.itens.add(item);
    }

    public List<Vinculo> getVinculos()
    {
        return vinculos;
    }
    public void setVinculo(List<Vinculo> vinculos)
    {
        this.vinculos = vinculos;
    }
    public void addVinculo(Vinculo vinculo)
    {
        this.vinculos.add(vinculo);
    }
}