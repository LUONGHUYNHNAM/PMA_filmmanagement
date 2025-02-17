package com.huynhnam.pma_filmanagement.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cast_members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CastMembers {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cast_id") 
    private Integer castId;
	@Column(name = "cast_name")
    private String castName;
	@OneToMany(mappedBy = "castMember", fetch = FetchType.EAGER)
	private List<MovieCasts> movieCasts;


    
   
}
