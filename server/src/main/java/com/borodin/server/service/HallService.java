package com.borodin.server.service;

import com.borodin.server.dao.HallDao;
import com.borodin.server.dao.PlacementDao;
import com.borodin.server.domain.Hall;
import com.borodin.server.domain.Place;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class HallService implements IService<Long, Hall> {

    HallDao hallDao = new HallDao();
    PlacementDao placementDao = new PlacementDao();

    @Override
    public List<Hall> getAll() {
        List<Hall> halls = hallDao.getAll();
        for (Hall entity :
                halls) {
            setPlacementAndPlaces(entity);
        }
        return halls;
    }

    @Override
    public Hall findById(Long id) {
        Hall hall = hallDao.findById(id);
        setPlacementAndPlaces(hall);
        return hall;
    }

    @Override
    public void deleteById(Long id) {
        hallDao.deleteById(id);
    }

    @Override
    public void update(Hall entity) {
        hallDao.update(entity);

        boolean[][] placement = entity.getPlacement();
        List<Integer[]> places = new LinkedList<>();

        for (int i = 0; i < placement.length; i++) {
            for (int j = 0; j < placement[i].length; j++) {
                if (placement[i][j]) {
                    places.add(new Integer[]{i, j});
                }
            }
        }

        placementDao.updateAll(places, entity.getId());
    }

    @Override
    public Hall create(Hall entity) {
        hallDao.create(entity);
        boolean[][] placement = entity.getPlacement();
        List<Integer[]> places = new LinkedList<>();

        for (int i = 0; i < placement.length; i++) {
            for (int j = 0; j < placement[i].length; j++) {
                if (placement[i][j]) {
                    places.add(new Integer[]{i, j});
                }
            }
        }

        placementDao.insertAll(places, entity.getId());
        return entity;
    }

    private void setPlacementAndPlaces(Hall entity) {
        boolean[][] placement = new boolean[entity.getHeight()][entity.getWidth()];

        for (Integer[] place :
                placementDao.findAllByHallId(entity.getId())) {
            placement[place[0]][place[1]] = true;
        }

        entity.setPlacement(placement);
        List<Place> places = new LinkedList<>();

        for (int i = 0, numPlace = 1; i < placement.length; i++) {
            for (int j = 0; j < placement[i].length; j++) {
                if (placement[i][j]) {
                    places.add(new Place(i, numPlace++));
                }
            }
        }
        entity.setPlaces(places);
    }

}
