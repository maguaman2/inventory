package com.example.inventory.repository

import com.example.inventory.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product?, Long?>{
    @Query(nativeQuery = true)
    fun sumPvpTimesStock(@Param ("categoryId") categoryId:Long?): Double

}