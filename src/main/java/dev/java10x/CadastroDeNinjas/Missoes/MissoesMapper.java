package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Component;


@Component
public class MissoesMapper {


    public MissoesModel mapMissoes(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        return missoesModel;
    }
    public MissoesDTO mapMissoes(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        return missoesDTO;
    }
}
