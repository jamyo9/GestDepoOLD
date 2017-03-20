package com.gestdepo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gestdepo.model.vo.Rol;

public class AccountUtils {
	
	public static List<Rol> transformRols(String choosenRoles, String defaultLanguage) {
		String[] rolsArray = choosenRoles.split(", ");
		List<Rol> rols = new ArrayList<Rol>();
		if (rols.size()>0) {
			Arrays.asList(rolsArray).forEach((rol)->rols.add(new Rol(Integer.parseInt(rol),"", defaultLanguage)));
		}
		return rols;
	}
	
}
