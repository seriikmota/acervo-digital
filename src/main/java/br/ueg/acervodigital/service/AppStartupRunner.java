package br.ueg.acervodigital.service;

import br.ueg.acervodigital.entities.Item;
import br.ueg.acervodigital.entities.Post;
import br.ueg.acervodigital.entities.User;
import br.ueg.acervodigital.repository.ItemRepository;
import br.ueg.acervodigital.repository.PostRepository;
import br.ueg.acervodigital.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class AppStartupRunner implements ApplicationRunner {
    public static final String NONE = "none";
    public static final String CREATE_DROP = "create-drop";
    public static final String CREATE = "create";
    public static final String UPDATE = "update";

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    private static final Logger LOG = LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public void initDados() {

        LOG.info("Iniciando a execução do método initDados()");
        if(!ddlAuto.equals(CREATE) && !ddlAuto.equals(CREATE_DROP)) {
            return;
        }
        User user = null;
        user = User.builder()
                .id(1L)
                .email("teste@gmail.com")
                .enabled(Boolean.TRUE)
                .function("Admin")
                .login("admin")
                .name("Administrador")
                .password("$2y$10$1MgdNcIduZBhvlTym.PKje0nDX54UVS28jTa2U3lB3JvrqAj4fAdq") // Senha == admin
                .build();
        this.userRepository.save(user);
        Item item = null;
        item = Item.builder()
                .approval(Boolean.FALSE)
                .name("Osso do pé da cobra")
                .collector("José das Couves")
                .colleactionYear(LocalDate.parse("1980-01-01"))
                .collection("Cobras com pé")
                .heritageDate(LocalDate.now())
                .location("Logo ali")
                .numberCode("00001")
                .period("Pré-escolar")
                .provenance("Onde o Judas perdeu as meias")
                .registerDate(LocalDate.now())
                .status(1)
                .user(user)
                .build();
        this.itemRepository.save(item);
        Post post = null;
        post = Post.builder()
                .tag("teste1;teste2;teste3")
                .approval(Boolean.FALSE)
                .content("Postagem de teste")
                .title("Título Teste")
                .subtitle("Subtitulo Teste")
                .publicationDate(LocalDateTime.now())
                .user(user)
                .build();
        this.postRepository.save(post);
        LOG.info("Finalizando a execução do método initDados()");
    }

    public void run(ApplicationArguments args) throws Exception {
        try {
                this.initDados();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
