package br.ufjf.dcc193.t3.documentos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String titulo;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable
    private List<Etiqueta> etiquetas;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Anotacao> anotacoes;

    // @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    // private List<Vinculo> vinculosOrigem;

    // @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    // private List<Vinculo> vinculosDestino;

    public Item()
    {
    }
    public Item(String titulo)
    {
        this.titulo = titulo;

        this.etiquetas = new ArrayList<Etiqueta>();
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

    public List<Etiqueta> getEtiquetas()
    {
        return etiquetas;
    }
    public void setEtiquetas(List<Etiqueta> etiquetas)
    {
        this.etiquetas = etiquetas;
    }
    public void addEtiqueta(Etiqueta etiqueta)
    {
        this.etiquetas.add(etiqueta);
    }
    public void removeEtiqueta(Etiqueta etiqueta)
    {
        this.etiquetas.remove(etiqueta);
    }

    public List<Anotacao> getAnotacoes()
    {
        return this.anotacoes;
    }
    public void setAnotacoes(List<Anotacao> anotacoes)
    {
        this.anotacoes = anotacoes;
    }
}