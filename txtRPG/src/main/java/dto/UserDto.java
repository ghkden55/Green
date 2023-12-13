package dto;


import domain.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private int Intel;
    private int Wealth;
    private int Sociability;
    private int Morality;
    private int Artistry;
    private int PTSD;

    public UserDto(){}

    public UserDto(User user){
        this.Intel = user.getIntel();
        this.Wealth = user.getWealth();
        this.Sociability = user.getSociability();
        this.Morality = user.getMorality();
        this.Artistry = user.getArtistry();
        this.PTSD = user.getPTSD();
    }

    public User toEntity() {
        return User.builder()
                .Intel(Intel)
                .Wealth(Wealth)
                .Sociability(Sociability)
                .Morality(Morality)
                .Artistry(Artistry)
                .PTSD(PTSD)
                .build();
    }
}
