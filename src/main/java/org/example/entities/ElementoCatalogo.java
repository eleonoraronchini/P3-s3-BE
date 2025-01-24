package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "catalogo_prodotti")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ElementoCatalogo {
    @Id
    @GeneratedValue
    @Column (name = "codice_ISBN")
    protected int codiceISBN;
    @Column(nullable = false)
    protected String titolo;
    @Column(name = "anno_di_pubblicazione", nullable = false)
    protected int annoDiPubblicazione;
    @Column(name = "numero_pagine", nullable = false)
    protected int numPagine;
    @ManyToMany(mappedBy = "elementiCatalogo")
    List<Prestito> elementiPresiInPrestito = new ArrayList<>();

    public ElementoCatalogo (String titolo, int annoDiPubblicazione, int numPagine){
        this.titolo=titolo;
        this.annoDiPubblicazione=annoDiPubblicazione;
        this.numPagine=numPagine;

    }

    public ElementoCatalogo() {
    }

    public int getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getNumPagine() {
        return numPagine;
    }


    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }


    public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setCodiceISBN(int codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    @Override
    public String toString() {
        return
                "CodiceISBN:" + codiceISBN +
                        ", Titolo: " + titolo +
                        ", Anno di pubblicazione:" + annoDiPubblicazione +
                        ", Numero di pagine:" + numPagine
                ;
    }
}

