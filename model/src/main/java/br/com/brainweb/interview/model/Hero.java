package br.com.brainweb.interview.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "hero")
public class Hero {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Race race;
    private Boolean enabled;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="updated_at")
    private Date updatedAt;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "power_stats_id", referencedColumnName = "id")
    private PowerStats powerStats;
    @Transient
    private UUID powerStatsId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public PowerStats getPowerStats() {
        return powerStats;
    }

    public void setPowerStats(PowerStats powerStats) {
        this.powerStats = powerStats;
    }

    public UUID getPowerStatsId() {
        return powerStatsId;
    }

    public void setPowerStatsId(UUID powerStatsId) {
        setPowerStats(new PowerStats(powerStatsId));
        this.powerStatsId = powerStatsId;
    }

    public enum Race {
        HUMAN, ALIEN, DIVINE, CYBORG;
    }
}
