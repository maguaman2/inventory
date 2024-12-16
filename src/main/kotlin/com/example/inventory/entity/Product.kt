package com.example.inventory.entity

import jakarta.persistence.*


@Entity
@Table(name = "product")
class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    val id: Long? = null
    var description: String? = null
    var pvp: Double? = null
    var stock: Int? = null
    @ManyToOne(fetch = FetchType.EAGER)
    var category: Category? = null
}
