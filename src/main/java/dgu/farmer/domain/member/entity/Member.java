package dgu.farmer.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String memberName;

    @Builder.Default
    @Column(nullable = false)
    private Integer points = 0;

    public void updatePoints(int amount) {
        this.points += amount;
    }
}
