package com.nba_stats.court_cardz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@Table(name="player_data")
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @Column(name = "player_id", unique = true)
    private int playerId;
    @NotBlank(message = "First name cannot be null.")
    @Column(name = "first_name")
    private String firstName;
    @NotBlank(message = "Last name cannot be null.")
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "team_id")
    private int teamId;
    @NotBlank(message = "Team name cannot be null.")
    @Column(name = "team_name")
    private String teamName;
    @NotBlank(message = "Age cannot be null.")
    @Column(name = "age")
    private double age;
    @Column(name = "fg_pct")
    private double fgPct;
    @Column(name = "fg3_pct")
    private double fg3Pct;
    @Column(name = "ft_pct")
    private double ftPct;
    private int reb;
    private int tov;
    private int stl;
    private int blk;
    private int pts;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getFgPct() {
        return fgPct;
    }

    public void setFgPct(double fgPct) {
        this.fgPct = fgPct;
    }

    public double getFg3Pct() {
        return fg3Pct;
    }

    public void setFg3Pct(double fg3Pct) {
        this.fg3Pct = fg3Pct;
    }

    public double getFtPct() {
        return ftPct;
    }

    public void setFtPct(double ftPct) {
        this.ftPct = ftPct;
    }

    public int getReb() {
        return reb;
    }

    public void setReb(int reb) {
        this.reb = reb;
    }

    public int getTov() {
        return tov;
    }

    public void setTov(int tov) {
        this.tov = tov;
    }

    public int getStl() {
        return stl;
    }

    public void setStl(int stl) {
        this.stl = stl;
    }

    public int getBlk() {
        return blk;
    }

    public void setBlk(int blk) {
        this.blk = blk;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }
}
