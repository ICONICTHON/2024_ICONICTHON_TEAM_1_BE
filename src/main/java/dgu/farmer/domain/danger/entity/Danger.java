package dgu.farmer.domain.danger.entity;

import dgu.farmer.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Danger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dangerId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Member member;

    @Column
    private String buildingName;

    @Column
    private String content;

    @Column
    private String imageUrl;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

}
