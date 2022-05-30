package io.github.leeseojune53.finder.domain.room.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Table(name = "tbl_room")
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3, unique = true)
    private String roomNumber;

    private Integer count;

    public void updateRoomInformation(String roomNumber, Integer count) {
        this.roomNumber = roomNumber;
        this.count = count;
    }

}
