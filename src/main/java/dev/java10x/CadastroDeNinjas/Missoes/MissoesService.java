package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaMapper;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;
    private final NinjaMapper ninjaMapper;


    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper, NinjaMapper ninjaMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todas as missoes
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream().
                map(missoesMapper::mapMissoes)
                .collect(Collectors.toList());
    }
    //Listar missao por ID
    public MissoesDTO listarMissaoPorId(Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return  missoesModel.map(missoesMapper::mapMissoes).orElse(null);
    }
    //Criar nova missao
    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missao = missoesMapper.mapMissoes(missoesDTO);
        missao =missoesRepository.save(missao);

        return missoesMapper.mapMissoes(missao);
    }
    //Deletar Missao
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }
    //Atulizar missao
    public MissoesDTO atualizarMissao(MissoesDTO missoesDTO,Long id){
        Optional<MissoesModel> missaoExiste = missoesRepository.findById(id);
        if(missaoExiste.isPresent()){
            MissoesModel missaoAtualizada= missoesMapper.mapMissoes(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.mapMissoes(missaoSalva);

        }return  null;
    }
    //Adicionar ninja na missao
    public MissoesDTO adicionarNinja(List<NinjaDTO> ninja, Long id){
        MissoesModel missaoAtulizada = missoesMapper.mapMissoes((MissoesDTO) ninja);
        missaoAtulizada.setId(id);
        missaoAtulizada = missoesRepository.save(missaoAtulizada);
        return missoesMapper.mapMissoes(missaoAtulizada);
    }
}
