package org.dao;

import org.dao.exception.DaoException;
import org.dto.MusicActivityDto;
import org.dto.TracksDto;

import java.util.List;

public interface MusicActivityDao {
    List<MusicActivityDto> getAllByUserId(int userId) throws DaoException;

    List<MusicActivityDto> getAllByTrackId(int trackId) throws DaoException;

    List<TracksDto> getPopularMusicByRoute(int routeId) throws DaoException;

}
