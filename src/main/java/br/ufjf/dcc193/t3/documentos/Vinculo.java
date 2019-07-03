package br.ufjf.dcc193.t3.documentos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vinculo
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable
    private List<Etiqueta> etiquetas;

    @OneToMany(mappedBy = "vinculo", cascade = CascadeType.ALL)
    private List<Anotacao> anotacoes;

    @ManyToOne
    @JoinColumn
    private List<Vinculo> itemOrigem;

    @ManyToOne
    @JoinColumn
    private List<Vinculo> itemDestino;

    public Vinculo()
    {
    }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public List<Etiqueta> getEtiquetas()
    {
        return etiquetas;
    }
    public void setEtiquetas(List<Etiqueta> etiquetas)
    {
        this.etiquetas = etiquetas;
    }

    public List<Anotacao> getAnotacoes()
    {
        return anotacoes;
    }
    public void setAnotacoes(List<Anotacao> anotacoes)
    {
        this.anotacoes = anotacoes;
    }

    public List<Vinculo> getItemOrigem()
    {
        return itemOrigem;
    }
    public void setItemOrigem(List<Vinculo> itemOrigem)
    {
        this.itemOrigem = itemOrigem;
    }

    public List<Vinculo> getItemDestino()
    {
        return itemDestino;
    }
    public void setItemDestino(List<Vinculo> itemDestino)
    {
        this.itemDestino = itemDestino;
    }


}