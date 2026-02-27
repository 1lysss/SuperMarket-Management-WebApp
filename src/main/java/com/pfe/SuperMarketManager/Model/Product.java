package com.pfe.SuperMarketManager.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    public enum UNIT{
        PACK, KG, LITER,ITEM
    }

}

