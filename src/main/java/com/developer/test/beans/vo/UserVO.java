package com.developer.test.beans.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	private Long id;
	private String nombre;
	private String a_Paterno;
	private String a_Materno;
	private RoleVO role;
}
