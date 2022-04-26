package io.github.leeseojune53.finder.domain.user.domain;

import io.github.leeseojune53.finder.domain.room.domain.Room;
import io.github.leeseojune53.finder.domain.user.domain.types.LifeStyle;
import io.github.leeseojune53.finder.domain.user.domain.types.Time;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 4, unique = true)
    private String number;

    @NotNull
    @Column(length = 60)
    private String password;

    @NotNull
    @Column(length = 5)
    private String name;

    @Column(length = 200)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private LifeStyle lifeStyle;

    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private Time bedTime;

    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private Time wakeUpTime;

    @NotNull
    @Column(length = 1)
    private String grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @Builder
    public User(String number, String name, String password) {
        this.number = number;
        this.name = name;
        this.password = password;
        this.grade = String.valueOf(number.charAt(0));
    }

    public void updateUserInformation(String description, LifeStyle lifeStyle, Time bedTime, Time wakeUpTime) {
        this.description = description;
        this.lifeStyle = lifeStyle;
        this.bedTime = bedTime;
        this.wakeUpTime = wakeUpTime;
    }

    public void setRoomNull() {
        this.room = null;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
