package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelService {

	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelInnerJoin();

	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelOuterLeftJoin();

	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion);

	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion);

}
