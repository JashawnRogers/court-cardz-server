package com.nba_stats.court_cardz.controller;

import com.nba_stats.court_cardz.model.Player;
import com.nba_stats.court_cardz.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

    private final PlayerService service;

    @Autowired
    public PlayerController(PlayerService service){
        this.service = service;
    }

    @GetMapping
    public PagedModel<Player> getPlayers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "25") int size
    ){
        return service.getAllPlayers(page, size);
    }
    @GetMapping("/{id}")
    public Player getPlayerByID(@PathVariable int id){
        return service.getPlayerByID(id);
    }

    @GetMapping("/")
    public List<Player> getPlayersByName(@RequestParam String name){
        return service.getPlayerByName(name);
    }

    @GetMapping("/{team}")
    public List<Player> getPlayersFromTeam(@PathVariable String team){
        return service.getPlayersFromTeam(team);
    }

    @PutMapping("/update/player")
    public Player updatePlayer(@Valid @RequestBody Player updatedPlayer){
        return service.updatePlayer(updatedPlayer);
    }

    @PostMapping("/create/player")
    public Player addPlayer(@Valid @RequestBody Player newPlayer){
       return service.addPlayer(newPlayer);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlayerById(@PathVariable int id){
        service.deletePlayerById(id);
    }
}
