package br.unitins.topicos1.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import br.unitins.topicos1.model.Camera;
import br.unitins.topicos1.repository.CameraRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;

@ApplicationScoped
public class CameraFileServiceImpl  implements FileService{
    // ex: /user/hugo/quarkus/imagens/camera
    private final String PATH_USER = System.getProperty("user.home")
        + File.separator + "quarkus" 
        + File.separator + "imagem"
        + File.separator + "camera" + File.separator;

    @Inject
    CameraRepository cameraRepository;

    @Override
    @Transactional
    public void salvar(Long id, String nomeImagem, byte[] imagem) {
        Camera camera = cameraRepository.findById(id);
        try {
            camera.setNomeImagem(salvarImagem(nomeImagem, imagem));
        } catch (IOException e) {
            throw new ValidationException(e.getMessage(), e);
        }
    }

    private String salvarImagem(String nomeImagem, byte[] imagem) throws IOException{
        // Verificar tipo da imagem
        String mimeType = Files.probeContentType(new File(nomeImagem).toPath());
        Log.info("MIME type detectado: " + mimeType);
        
        List<String> listMimeType = Arrays.asList("image/jpg", "image/gif", "image/png", "image/jpeg");

        if(mimeType == null){
            throw new IOException("Tipo de imagem não encontrado");
        }

        if (!listMimeType.contains(mimeType)) 
            throw new IOException("Tipo de imagem não suportado");
        
        // Verifica o tamanho do arquivo ("Não é permitido maior que 10mb")
        if(imagem.length > 1024*1024*10)
            throw new IOException("Arquivo muito grande, tamanho máximo de 10mb.");

        File diretorio = new File(PATH_USER);

        if(!diretorio.exists()){
            if (diretorio.mkdirs()) {
                Log.info("Diretorio criado com sucesso: " + PATH_USER);
            } else {
                throw new IOException("Falha ao criar diretorio: " + PATH_USER);
            }
        }

        // Gerar nome do arquivo
        String nomeArquivo = UUID.randomUUID()
                                                    + "."
                                                    + mimeType.substring(mimeType.lastIndexOf("/") + 1);
        String path = PATH_USER + nomeArquivo;

        // Salvar arquivo
        File file = new File(path);
        if(file.exists())
            throw new IOException("Este arquivo já existe");

        // Criar o arquivo no SO
        file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagem);
        fos.flush();
        fos.close();

        return nomeArquivo;
    }

    @Override
    public File download(String nomeImagem) {
        return new File(PATH_USER + nomeImagem);
    }
}
