package io.github.leeseojune53.finder.domain.user.domain;

import io.github.leeseojune53.finder.domain.user.domain.types.LifeStyle;
import io.github.leeseojune53.finder.domain.user.domain.types.Time;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Column(length = 4)
    private String number;

    @NotNull
    @Column(length = 5)
    private String name;

    @Column
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


}
