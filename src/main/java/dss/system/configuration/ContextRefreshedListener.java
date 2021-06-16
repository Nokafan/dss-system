package dss.system.configuration;

import static dss.system.configuration.Constants.TEST_I_UA;

import dss.system.entity.Building;
import dss.system.entity.BuildingProperty;
import dss.system.entity.Property;
import dss.system.entity.User;
import dss.system.repository.BuildingRepository;
import dss.system.repository.PropertyRepository;
import dss.system.repository.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
    private final BCryptPasswordEncoder passwordEncoder;
    private final PropertyRepository propertyRepository;
    private final BuildingRepository buildingRepository;
    private final UserRepository userRepository;

    @Autowired
    public ContextRefreshedListener(BCryptPasswordEncoder passwordEncoder,
                                    PropertyRepository propertyRepository,
                                    BuildingRepository buildingRepository,
                                    UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.propertyRepository = propertyRepository;
        this.buildingRepository = buildingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        propertyRepository.saveAll(createDemoProperties());
        log.info("List of properties are saved");
        List<Building> demoBuilding = createDemoBuilding();
        demoBuilding.get(0).setBuildingProperties(createDemoBuildingOneProperties());
        demoBuilding.get(1).setBuildingProperties(createDemoBuildingTwoProperties());
        buildingRepository.saveAll(demoBuilding);
        log.info("List of buildings are saved");

        User user = User.builder()
                .email(TEST_I_UA)
                .password(passwordEncoder.encode("Password1"))
                .build();
        log.info("User created");
        userRepository.save(user);
        log.info("User saved");

    }

    private List<Property> createDemoProperties() {
        List<String> listQuestions = new ArrayList<>();
        {
            listQuestions.add("Де знаходиться приміщення?");
            listQuestions.add("Розміщення вигідне?");
            listQuestions.add("Ціна оренди");
            listQuestions.add("Відвідуваність місця за день");
            listQuestions.add("Наявність електропостачання");
            listQuestions.add("Площа");
            listQuestions.add("Оренда довгострокова?");
            listQuestions.add("Вік цільової аудиторії");
            listQuestions.add("Район");
            listQuestions.add("Кількість населення в районі");
            listQuestions.add("Поверх, де знаходиться приміщення");
            listQuestions.add("Стан приміщення");
            listQuestions.add("Наявність водопостачання");
            listQuestions.add("Наявність системи опалення");
            listQuestions.add("Наявність каналізації");
            listQuestions.add("Наявність вентиляційної системи");
            listQuestions.add("Чи зручно добиратися ?");
            listQuestions.add("Наявність складського приміщення");
            listQuestions.add("Наявність паркомісць");
            listQuestions.add("Кількість паркомісць");
            listQuestions.add("Наявність зовнішніх рекламних конструкцій");
            listQuestions.add("Який відсоток \"плинності\" орендарів ?");
            listQuestions.add("Чи передбачені програми лояльності ?");
            listQuestions.add("Чи включені в орендну плату комунальні платежі?");
            listQuestions.add("Чи включені в орендну плату витрати на прибирання?");
            listQuestions.add("Чи надається інтернет - провайдер ?");
            listQuestions.add("Наявність конкурентів біля приміщення");
            listQuestions.add("Чи є місце для реклами та вітрини ?");
            listQuestions.add("Чи високі стелі в магазині?");
            listQuestions.add("Наявність ремонту");
            listQuestions.add("Відгуки про орендодавця");
            listQuestions.add("Наявність спеціального підйому для інвалідів");
            listQuestions.add("Наявність договору с службою безпеки");
            listQuestions.add("Наявність камер спостереження");
            listQuestions.add("Якість будматеріалів");
            listQuestions.add("Наяність поблизу зупинок громадського транспорту");
            listQuestions.add("Площа складського приміщення");
            listQuestions.add("Наявність кондиціонерів");
            listQuestions.add("Окремий вхід у приміщення");
            listQuestions.add("Тип приміщення");
            listQuestions.add("Оренда короткострокова?");
            listQuestions.add("Тип освітлення приміщення");
            listQuestions.add("Можливість робити ремонт");
            listQuestions.add("Наявність поблизу станцій метрополітену");
            listQuestions.add("Наскільки добре видно приміщення з дороги");
            listQuestions.add("Наявність полиць");
            listQuestions.add("Наявність чорного виходу");
            listQuestions.add("Наявність вільного заїзду до приміщення");
            listQuestions.add("Наявність місця для сміттєвих баків");
            listQuestions.add("Густота населення району");
        }
        List<Property> propertyList = new ArrayList<>();
        for (String question : listQuestions) {
            Property property = Property.builder()
                    .title(question)
                    .build();
            propertyList.add(property);
        }
        return propertyList;
    }

    private List<Building> createDemoBuilding() {
        Building buildingOne = Building.builder()
                .title("First building")
                .address("7a, Vazlava Gavela str.")
                .build();
        Building buildingTwo = Building.builder()
                .title("Second building")
                .address("1103, Very Nice str.")
                .build();
        return new ArrayList<>(Arrays.asList(buildingOne, buildingTwo));
    }

    private List<BuildingProperty> createDemoBuildingOneProperties() {
        List<String> stringPropertyValueBuildingOne = new ArrayList<>(
                Arrays.asList(
                        "Біля метро",
                        "Так",
                        "Менше 50000 грн",
                        "Більше 3000 осіб",
                        "Так",
                        "Більше 100 м^2",
                        "Так",
                        "Більше 35 років",
                        "Житловий",
                        "Більше 200000",
                        "1",
                        "Підходить",
                        "Так",
                        "Так",
                        "Так",
                        "Так",
                        "Так",
                        "Так",
                        "Так",
                        "Більше 20 шт",
                        "Так",
                        "Менше 50%",
                        "23 Так",
                        "Так",
                        "Так",
                        "Так",
                        "Ні",
                        "Так",
                        "Так",
                        "Так",
                        "Позитивні",
                        "Так",
                        "Так",
                        "Так",
                        "Якісні",
                        "Так",
                        "Більше 20 м^2",
                        "Так",
                        "Так",
                        "Під магазин",
                        "Ні",
                        "Суміщене(природне і штучне)",
                        "Є",
                        "Так",
                        "Добре",
                        "Так",
                        "Так",
                        "Так",
                        "Є",
                        "Більше 5 тис"
                )
        );
        List<Property> propertyList = propertyRepository.findAll();
        List<BuildingProperty> buildingProperties = new ArrayList<>();

        for (int i = 0; i < stringPropertyValueBuildingOne.size(); i++) {
            BuildingProperty buildingOneProperty = BuildingProperty.builder()
                    .title(propertyList.get(i))
                    .value(stringPropertyValueBuildingOne.get(i))
                    .build();
            buildingProperties.add(buildingOneProperty);
        }
        return buildingProperties;
    }

    private List<BuildingProperty> createDemoBuildingTwoProperties() {
        List<String> stringPropertyValueBuildingTwo = new ArrayList<>(
                Arrays.asList(
                        "Біля метро",
                        "Так",
                        "Менше 60000 грн",
                        "Більше 3000 осіб",
                        "Так",
                        "Більше 200 м^2",
                        "Так",
                        "Більше 35 років",
                        "Житловий",
                        "Більше 200000",
                        "1",
                        "Підходить",
                        "Так",
                        "Так",
                        "Так",
                        "Так",
                        "Так",
                        "Так",
                        "Так",
                        "Більше 20 шт",
                        "Ні",
                        "Менше 50%",
                        "Так",
                        "Так",
                        "Так",
                        "Так",
                        "Ні",
                        "Так",
                        "Ні",
                        "Так",
                        "Нейтральні",
                        "Так",
                        "Так",
                        "Так",
                        "Якісні",
                        "Так",
                        "Більше 20 м^2",
                        "Так",
                        "Так",
                        "Під магазин",
                        "Ні",
                        "Суміщене(природне і штучне)",
                        "Є",
                        "Так",
                        "Добре",
                        "Ні",
                        "Так",
                        "Так",
                        "Є",
                        "Більше 5 тис"
                )
        );
        List<Property> propertyList = propertyRepository.findAll();
        List<BuildingProperty> buildingProperties = new ArrayList<>();

        for (int i = 0; i < stringPropertyValueBuildingTwo.size(); i++) {
            BuildingProperty buildingTwoProperty = BuildingProperty.builder()
                    .title(propertyList.get(i))
                    .value(stringPropertyValueBuildingTwo.get(i)).build();
            buildingProperties.add(buildingTwoProperty);
        }
        return buildingProperties;
    }
}
