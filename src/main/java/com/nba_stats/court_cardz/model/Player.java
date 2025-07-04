package com.nba_stats.court_cardz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    private int player_id;
    private String first_name;
    private String last_name;
    private int team_id;
    private String team_name;
    private double age;
    private double fg_pct;
    private double fg3_pct;
    private double ft_pct;
    private int reb;
    private int tov;
    private int stl;
    private int blk;
    private int pts;



}
