package com.xavipandis.liga.repository;

import com.xavipandis.liga.domain.Jugador;
import com.xavipandis.liga.domain.Equipo;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA repository for the Jugador entity.
 */
public interface JugadorRepository extends JpaRepository<Jugador,Long> {

    @Query("select j from Jugador j where j.canastasTotales >= :canastasTotales")
    List<Jugador> EcuentraCanastas(@Param("canastasTotales") Integer canastasTotales);

    @Query("select j from Jugador j, Equipo eq where j.equipo.id = eq.id and j.canastasTotales >= :canastasTotales and j.equipo.id = :equiposelec")
    List<Jugador> Variante(@Param("canastasTotales") Integer canastasTotales, @Param("equiposelec") Long equiposelec);
}
