package tn.esprit.jsf.esook.managedBean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;
import org.primefaces.showcase.push.chat.ChatUsers;

import tn.edu.esprit.Pidev.Entity.User;
import tn.edu.esprit.Pidev.services.GestionAcount;
import tn.edu.esprit.Pidev.services.GestionAcountLocal;
import tn.edu.esprit.Pidev.services.GestionUser;
import tn.esprit.Pidev.exception.BadCredentialException;

@SessionScoped
@ManagedBean(name = "authentication")
public class Authentification {

	@EJB
	private GestionAcountLocal accountServices;

	@EJB
	private GestionUser useGestionUser;

	private String login;
	private String passeword;
	private boolean keepMeSignedIn;
	private boolean logged;

	 public String doLogin() {
	 try {
	 Object object = accountServices.retrieveAccountByCredentials(login,
	 passeword);
	 System.out.println(object);
	 if (object instanceof User) {
	 logged = true;
	 return "/pages/account/register?faces-redirect=true";
	 } else {
	 logged = true;
	 return "/pages/account/404?faces-redirect=true";
	 }
	 } catch (BadCredentialException e) {
	 return "login?faces-redirect=true";
	 }
	 }
	
//	public String doLogin() {
//		User user = useGestionUser.authentificatUser(login, passeword);
//		if (user instanceof User) {
//			logged = true;
//			return "/pages/account/chat?faces-redirect=true";
//		} else {
//			logged = true;
//			return "/pages/account/404?faces-redirect=true";
//		}
//
//	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "login?faces-redirect=true";
	}

	public String doReset() {
		login = null;
		passeword = "";
		return "login?faces-redirect=true";

	}

	public Authentification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasseword() {
		return passeword;
	}

	public void setPasseword(String passeword) {
		this.passeword = passeword;
	}

	public boolean isKeepMeSignedIn() {
		return keepMeSignedIn;
	}

	public void setKeepMeSignedIn(boolean keepMeSignedIn) {
		this.keepMeSignedIn = keepMeSignedIn;
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	/*******/
	/************ CHAT **************/
	private final EventBus eventBus = EventBusFactory.getDefault().eventBus();

	@ManagedProperty("#{chatUsers}")
	private ChatUsers users;

	private String privateMessage;

	private String globalMessage;

	private String username;

	private boolean loggedIn;

	private String privateUser;

	private final static String CHANNEL = "/{room}/";

	public ChatUsers getUsers() {
		return users;
	}

	public void setUsers(ChatUsers users) {
		this.users = users;
	}

	public String getPrivateUser() {
		return privateUser;
	}

	public void setPrivateUser(String privateUser) {
		this.privateUser = privateUser;
	}

	public String getGlobalMessage() {
		return globalMessage;
	}

	public void setGlobalMessage(String globalMessage) {
		this.globalMessage = globalMessage;
	}

	public String getPrivateMessage() {
		return privateMessage;
	}

	public void setPrivateMessage(String privateMessage) {
		this.privateMessage = privateMessage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void sendGlobal() {
		eventBus.publish(CHANNEL + "*", login + ": " + globalMessage);

		globalMessage = null;
	}

	public void sendPrivate() {
		eventBus.publish(CHANNEL + privateUser, "[PM] " + login + ": "
				+ privateMessage);

		privateMessage = null;
	}

	public String login() {
		RequestContext requestContext = RequestContext.getCurrentInstance();

		if (users.contains(username)) {
			loggedIn = false;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Username taken", "Try with another username."));
			requestContext.update("growl");
		} else {
			users.add(login);
			requestContext
					.execute("PF('subscriber').connect('/" + login + "')");
			loggedIn = true;
		}
		return null;
	}

	public void disconnect() {
		// remove user and update ui
		users.remove(login);
		RequestContext.getCurrentInstance().update("form:users");

		// push leave information
		eventBus.publish(CHANNEL + "*", login + " left the channel.");

		// reset state
		loggedIn = false;
		username = null;
	}

	/***/
}
