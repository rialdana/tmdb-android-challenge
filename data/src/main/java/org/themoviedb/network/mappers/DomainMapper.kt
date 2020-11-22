package org.themoviedb.network.mappers

interface DomainMapper<T : Any> {
    fun mapToDomainModel(): T
}