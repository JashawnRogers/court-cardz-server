package com.nba_stats.court_cardz.service;

import com.nba_stats.court_cardz.exceptions.DuplicatePlayerException;
import com.nba_stats.court_cardz.exceptions.PlayerNotFoundException;
import com.nba_stats.court_cardz.model.Player;
import com.nba_stats.court_cardz.repository.PlayerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepo repo;

    @Autowired
    public PlayerService(PlayerRepo repo){
        this.repo = repo;
    }

    public PagedModel<Player> getAllPlayers(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Player> players = repo.findByOrderByFirstNameDesc(pageable);
        return new PagedModel<>(players);
    }

    public Player getPlayerByID(int id){
        return repo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with ID: " + id));
    }

    public List<Player> getPlayerByName(String name){
//        Passes in same name variable twice to satisfy query
        return repo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
    }

    public List<Player> getPlayersFromTeam(String team){
        return repo.findAll().stream()
                .filter(player -> team.equalsIgnoreCase(player.getTeamName()))
                .collect(Collectors.toList());
    }

    @Transactional
   public Player updatePlayer(Player updatedPlayer){
        Optional<Player> existingPlayer = repo.findById(updatedPlayer.getPlayerId());

        if (existingPlayer.isPresent()){
            Player playerToUpdate = existingPlayer.get();

            playerToUpdate.setFirstName(updatedPlayer.getFirstName());
            playerToUpdate.setLastName(updatedPlayer.getLastName());
            playerToUpdate.setTeamName(updatedPlayer.getTeamName());
            playerToUpdate.setAge(updatedPlayer.getAge());

            return repo.save(playerToUpdate);
        } else {
            throw new PlayerNotFoundException("Player not found with ID: " + updatedPlayer.getPlayerId());
        }
   }

   @Transactional
   public Player addPlayer(Player newPlayer){
        if(repo.existsById(newPlayer.getPlayerId())){
            throw new DuplicatePlayerException("Player with ID already exists.");
        }
        repo.save(newPlayer);
        return newPlayer;
   }

   @Transactional
   public void deletePlayerById(int id){
        if (!repo.existsById(id)){
            throw new PlayerNotFoundException("Cannot delete: player with ID " + id + " does not exist.");
        }
        repo.deleteById(id);
   }
}
