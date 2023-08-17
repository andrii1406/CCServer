package ccserver;

import ccserver.dto.*;
import ccserver.dto.jwt.RoleDTO;
import ccserver.dto.jwt.UserDTO;
import ccserver.entity.jwt.ERole;
import ccserver.service.*;
import ccserver.service.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CcServerApplication {

	private static ServiceRole roleService;

	private static ServiceOperation opService;

	private static ServiceKstat ksService;

	private static ServiceCurrency crService;

	private static ServiceFilial cnService;

	private static ServiceUser userService;

	private static PasswordEncoder passwordEncoder;

	private static ServiceObmen obService;

	private static ServiceOstatki ostService;


	@Autowired
	public CcServerApplication(
			ServiceConfigRole roleConfig,
			ServiceConfigOperation operationConfig,
			ServiceConfigObmen obmenConfig,
			ServiceConfigKstat kstatConfig,
			ServiceConfigCurrency currencyConfig,
			ServiceConfigFilial filialConfig,
			ServiceConfigUser userConfig,
			PasswordEncoder passwordEncoder,
			ServiceConfigOstatki ostatkiConfig
	) {
		CcServerApplication.roleService = (ServiceRole) roleConfig.getService();
		CcServerApplication.opService = (ServiceOperation) operationConfig.getService();
		CcServerApplication.ksService = (ServiceKstat) kstatConfig.getService();
		CcServerApplication.crService = (ServiceCurrency) currencyConfig.getService();
		CcServerApplication.cnService = (ServiceFilial) filialConfig.getService();
		CcServerApplication.userService = (ServiceUser) userConfig.getService();
		CcServerApplication.passwordEncoder = passwordEncoder;
		CcServerApplication.obService = (ServiceObmen) obmenConfig.getService();
		CcServerApplication.ostService = (ServiceOstatki) ostatkiConfig.getService();
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		SpringApplication.run(CcServerApplication.class, args);

		roleService.create(new RoleDTO(1L, ERole.ROLE_ADMIN));
		roleService.create(new RoleDTO(2L, ERole.ROLE_USER));
		roleService.create(new RoleDTO(3L, ERole.ROLE_GUEST));

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("admin"));
		authorities.add(new SimpleGrantedAuthority("user"));
		authorities.add(new SimpleGrantedAuthority("guest"));

		userService.create(new UserDTO(
				null,
				"admin",
				"hamann@motorsport.de",
				passwordEncoder.encode("123"),
				authorities
		));

		opService.create(new OperationDTO(0L, "приход"));
		opService.create(new OperationDTO(1L, "расход"));

		crService.create(new CurrencyDTO(1L, "USD"));
		crService.create(new CurrencyDTO(2L, "EUR"));
		crService.create(new CurrencyDTO(3L, "RUR"));
		crService.create(new CurrencyDTO(4L, "UAH"));
		crService.create(new CurrencyDTO(5L, "GBP"));
		crService.create(new CurrencyDTO(6L, "PLN"));

		ksService.create(new KstatDTO(0L, ""));
		ksService.create(new KstatDTO(1L, "Зар. плата"));
		ksService.create(new KstatDTO(2L, "Хоз. расходы"));

		cnService.create(new FilialDTO(6L, 6L,"6"));
		cnService.create(new FilialDTO(10L, 10L, "10"));
		cnService.create(new FilialDTO(51L, 10L, "51"));

		obService.create(new ObmenDTO(0L, "приём"));
		obService.create(new ObmenDTO(1L, "продажа"));
		obService.create(new ObmenDTO(2L, "опт"));
	}

}
