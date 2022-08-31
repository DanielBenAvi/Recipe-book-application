package View;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;

import Exceptions.EmptyException;
import Exceptions.ExistsException;
import Exceptions.InValidInputException;
import Model.Ingredient;
import Model.Recipe;
import Model.RecipeLink;
import Model.RecipeRegular;
import Model.Step;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.stage.FileChooser.ExtensionFilter;

public class View_All {

	private Stage stage;
	private Group groupAllRecipes;
	private Scene sceneAll;
	private VBox VBox_allRecipes;
	private ListView<String> allRecipesListView;
	private Button button_AllRecipes_inAll, buttonFavoriets_inAll, buttonSearch_inAll, buttonWeb_inFav,
			buttonInfo_inAll;
	private Label label_AllRecipes;
	private Group groupFavoriets;
	private Label label_Favorites;
	private VBox vbox_Favorites;
	private ListView<String> favoritesListView;
	private HBox allRecipes_ToolBar;
	private HBox favoriets_ToolBar;
	private Button buttonWeb_inAll;
	private Button button_AllRecipes_inFav;
	private Button buttonFavoriets_inFav;
	private Button buttonInfo_inFav;
	private Button buttonSearch_inFav;
	private Scene sceneFavoriets;
	private Group groupSearch;
	private Scene sceneSearch;
	private VBox vbox_search;
	private HBox search_ToolBar;
	private Button button_AllRecipes_inSearch;
	private Button buttonFavoriets_inSearch;
	private Button buttonWeb_inSearch;
	private Button buttonSearch_inSearch;
	private Button buttonInfo_inSearch;
	private TextField textField_search;
	private Label label_Search;
	private ListView<String> searchListView;
	private VBox vbox_Web;
	private Label label_Web;
	private HBox web_ToolBar;
	private Button button_AllRecipes_inWeb;
	private Button buttonFavoriets_inWeb;
	private Button buttonSearch_inWeb;
	private Button buttonWeb_inWeb;
	private Button buttonInfo_inWeb;
	private Group groupWeb;
	private Scene sceneWeb;
	private TextField textField_webSearch;
	private VBox vbox_Profile;
	private Label label_Profile;
	private HBox profile_ToolBar;
	private Button button_AllRecipes_inProfile;
	private Button buttonFavoriets_inProfile;
	private Button buttonWeb_inProfile;
	private Button buttonSearch_inProfile;
	private Button buttonInfo_inProfile;
	private Group groupProfile;
	private Scene sceneProfile;
	private Button button_addRecipeRegular;
	private StackPane stackPane_addRecipeRegular;
	private Button button_addlinkRecipe;
	private HBox Hbox_SearchField_Web;
	private Button button_SearchFromWebAddress;
	private WebView webView_SearchRecipe;
	private WebEngine webEngin_SearchRecipe;
	private TextField textField_web_name;
	private HBox hBox_format_table_AllRecipes;
	private VBox VBOX_ViewRergularRecipe;
	private Label label_RecipeName_AllRecipes;
	private Region label_Ingredients_AllRecipes;
	private Label label_Steps_AllRecipes;
	private TextArea textArea_ingredients_allRecipes;
	private TextArea textArea_Steps_allRecipes;
	private HBox favoriets_Formating;
	private VBox VBOX_ViewRergularRecipe_favorite;
	private Label label_RecipeName_favorite;
	private Label label_Ingredients_favorite;
	private TextArea textArea_ingredients_favorite;
	private Label label_Steps_favorite;
	private TextArea textArea_Steps_favorite;
	private Group groupAddRegularRecipe;
	private VBox vbox_AddRegularRecipe;
	private Scene sceneAddRegularRecipe;
	private Label label_AddRegularRecipe;
	private HBox hbox_label_addRegularRecipe;
	private Button button_BackFromAddRecipeRegular;
	private HBox hbox_FormatAddRegularrecipe;
	private TextField textField_newRecipeName;
	private VBox Vbox_1THrds;
	private VBox Vbox_2THrds;
	private VBox Vbox_3THrds;
	private ImageView imagwView_addNewRecipeRegular;
	private Button button_uploadPhotoAddRecipeRegular;
	private Group groupInitProgram;
	private Scene SceneInitProgram;
	private Button Button_initProgram;
	private Label label_initProgram;
	private StackPane stackPane_viewRecipe;
	private WebView webView_ViewRecipeLink;
	private WebEngine webEngin_ViewRecipeLink;
	private Label label_addRegular_Ingredients;
	private TableView<Ingredient> tableView_addIngr;
	private TableColumn<Ingredient, String> ingredientName;
	private TableColumn<Ingredient, Double> ingredientAmount;
	private TableColumn<Ingredient, String> ingredientWeightType;
	private HBox Hbox_TextFieldsING;
	private TextField TextField_IngName;
	private TextField TextField_IngAmount;
	private Button button_AddIng;
	private Region label_addRegular_steps;
	private TableView<Step> tableView_addsteps;
	private TableColumn<Step, Integer> stepsNum;
	private TableColumn<Step, String> stepsStep;
	private TextField TextField_Step;
	private Button button_AddStep;
	private TextField TextField_StepNUM;
	private HBox HBox_steps_textField;
	private VBox Vbox_initProgram;
	private Label label_userName;
	private Label label_password;
	private ComboBox<String> comboBox_ingType;
	private Button button_addNewRecipeRegular;
	private Button button_Search;
	private HBox hbox_searchBar;
	private HBox HBox_headlineRecipeViewALl;
	private CheckBox checkBox_sceneAll;
	private WebView favoritesWebview;
	private StackPane stackPane_favorites;
	private WebEngine favoritesWebEngin;
	private HBox Hbox_imageAllRecipes;
	private ImageView ImageView_AllRecipes;
	private VBox Vbox_DEL_UPDATE;
	private VBox Vbox_labelIng;
	private String[] intTypeArray = { "gr", "small spoon", "big spoon", "kg", "cup", "bundle", "clove", "unit", "ml",
			"liter", "quarts" };
	private VBox Vbox_imageView_Delete;
	private Button button_delete;
	private Button button_Update;
	private Button button_backFromUpdate;
	private TextField textField_nameUpdate;
	private Button button_saveFromUpdate;
	private Group groupUpdateRecipe;
	private Scene sceneUpdateRecipe;
	private VBox Vbox_updateMain;
	private HBox Hbox_headline_update;
	private HBox Hbox_DEL_UPDATE;
	private HBox HBox_TabelsUpdate;
	private VBox VBox_ingredUpdate;
	private Label label_ingredUpdate;
	private TableView<Ingredient> tableView_updateIngred;
	private TableColumn<Ingredient, String> update_updateIngred_ingredientName;
	private TableColumn<Ingredient, Double> update_updateIngred_ingredientAmount;
	private TableColumn<Ingredient, String> update_updateIngred_ingredientWeightType;
	private VBox VBox_stepsUpdate;
	private Label label_StepsUpdate;
	private TableView<Step> tableView_StepsUpdate;
	private TableColumn<Step, Integer> tableCol_StepsUpdate_num;
	private TableColumn<Step, String> tableCol_StepsUpdate_step;
	private VBox VBox_TextFeldUpdate;
	private Label Label_nameUpdate;

	public View_All(Stage stageAllRecipe) {

		init_startMenu();
		init_allRecipes();
		init_favorites();
		init_search();
		init_webView();
		init_profile();
		init_updateRecipe();
		init_addRegularRecipe();
		this.stage = stageAllRecipe;
		stageAllRecipe.setResizable(false);
		stageAllRecipe.setScene(SceneInitProgram);
		stageAllRecipe.setTitle("CookingBook");
		stageAllRecipe.show();
	}

	public void initAlert(String text, AlertType type) {
		Alert errorAlert = new Alert(type);
		errorAlert.setHeaderText(null);
		errorAlert.setContentText(text);
		errorAlert.showAndWait();
	}

	@SuppressWarnings("unchecked")
	private void init_updateRecipe() {
		Vbox_updateMain = new VBox();
		// back button
		Hbox_headline_update = new HBox();
		Hbox_headline_update.setPrefSize(1000, 50);
		button_backFromUpdate = new Button("Back");
		button_backFromUpdate.setPrefSize(100, 50);
		// TextField = new TextFeild
		VBox_TextFeldUpdate = new VBox();
		textField_nameUpdate = new TextField();
		textField_nameUpdate.setPrefSize(800, 25);
		textField_nameUpdate.setPromptText("Enter new name here");
		Label_nameUpdate = new Label();
		Label_nameUpdate.setPrefSize(800, 25);
		Label_nameUpdate.getStylesheets().add(getClass().getResource("/CSS/LabelView.css").toExternalForm());

		VBox_TextFeldUpdate.getChildren().addAll(Label_nameUpdate, textField_nameUpdate);
		// button update
		button_saveFromUpdate = new Button("save");
		button_saveFromUpdate.setPrefSize(100, 50);
		Hbox_headline_update.getChildren().addAll(button_backFromUpdate, VBox_TextFeldUpdate, button_saveFromUpdate);
		// ingred table
		HBox_TabelsUpdate = new HBox();
		HBox_TabelsUpdate.setPrefSize(1000, 550);
		VBox_ingredUpdate = new VBox();
		label_ingredUpdate = new Label("Ingedients");
		label_ingredUpdate.setPrefSize(500, 50);
		label_ingredUpdate.getStylesheets().add(getClass().getResource("/CSS/LabelView.css").toExternalForm());

		tableView_updateIngred = new TableView<Ingredient>();
		tableView_updateIngred.setPrefSize(500, 500);
		tableView_updateIngred.getStylesheets().add(getClass().getResource("/CSS/Table.css").toExternalForm());
		tableView_updateIngred.setEditable(true);
		update_updateIngred_ingredientName = new TableColumn<Ingredient, String>("Name");
		update_updateIngred_ingredientName
				.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("ingredientName"));
		update_updateIngred_ingredientName.setPrefWidth(500 / 3);
		update_updateIngred_ingredientName.setEditable(true);

		update_updateIngred_ingredientAmount = new TableColumn<Ingredient, Double>("Amount");
		update_updateIngred_ingredientAmount
				.setCellValueFactory(new PropertyValueFactory<Ingredient, Double>("ingredientAmount"));
		update_updateIngred_ingredientAmount.setPrefWidth(500 / 3);
		update_updateIngred_ingredientAmount.setEditable(true);
		try {
			update_updateIngred_ingredientAmount
					.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
			update_updateIngred_ingredientAmount
					.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Ingredient, Double>>() {

						@Override
						public void handle(CellEditEvent<Ingredient, Double> event) {
							Ingredient ingredient = event.getRowValue();
							ingredient.setIngredientAmount(event.getNewValue());
						}
					});
		} catch (NumberFormatException e) {
			initAlert("must enter number", AlertType.WARNING);
		} catch (InputMismatchException e) {
			initAlert("InputMismatchException", AlertType.WARNING);
		}

		update_updateIngred_ingredientWeightType = new TableColumn<Ingredient, String>("Type");
		update_updateIngred_ingredientWeightType
				.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("ingredientWeightType"));
		update_updateIngred_ingredientWeightType.setPrefWidth(500 / 3);
		update_updateIngred_ingredientWeightType.setEditable(false);

		tableView_updateIngred.getColumns().addAll(update_updateIngred_ingredientName,
				update_updateIngred_ingredientAmount, update_updateIngred_ingredientWeightType);
		VBox_ingredUpdate.getChildren().addAll(label_ingredUpdate, tableView_updateIngred);
		// steps table
		VBox_stepsUpdate = new VBox();
		label_StepsUpdate = new Label("Steps");
		label_StepsUpdate.setPrefSize(500, 50);
		label_StepsUpdate.getStylesheets().add(getClass().getResource("/CSS/LabelView.css").toExternalForm());

		tableView_StepsUpdate = new TableView<Step>();
		tableView_StepsUpdate.getStylesheets().add(getClass().getResource("/CSS/Table.css").toExternalForm());
		tableView_StepsUpdate.setPrefSize(500, 500);
		tableView_StepsUpdate.setEditable(true);

		tableCol_StepsUpdate_num = new TableColumn<Step, Integer>("Num");
		tableCol_StepsUpdate_num.setCellValueFactory(new PropertyValueFactory<Step, Integer>("num"));
		tableCol_StepsUpdate_num.setPrefWidth(50);
		tableCol_StepsUpdate_num.setEditable(false);

		tableCol_StepsUpdate_step = new TableColumn<Step, String>("Step");
		tableCol_StepsUpdate_step.setCellValueFactory(new PropertyValueFactory<Step, String>("step"));
		tableCol_StepsUpdate_step.setPrefWidth(450);
		tableCol_StepsUpdate_step.setEditable(true);
		tableCol_StepsUpdate_step.setCellFactory(TextFieldTableCell.forTableColumn());
		tableCol_StepsUpdate_step.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Step, String>>() {

			@Override
			public void handle(CellEditEvent<Step, String> event) {
				Step step = event.getRowValue();
				step.setStep(event.getNewValue());
			}

		});

		tableView_StepsUpdate.getColumns().addAll(tableCol_StepsUpdate_num, tableCol_StepsUpdate_step);

		VBox_stepsUpdate.getChildren().addAll(label_StepsUpdate, tableView_StepsUpdate);
		HBox_TabelsUpdate.getChildren().addAll(VBox_ingredUpdate, VBox_stepsUpdate);
		Vbox_updateMain.getChildren().addAll(Hbox_headline_update, HBox_TabelsUpdate);

		groupUpdateRecipe = new Group();
		groupUpdateRecipe.getStylesheets().add(getClass().getResource("/CSS/FullStyle.css").toExternalForm());
		groupUpdateRecipe.getChildren().addAll(Vbox_updateMain);
		sceneUpdateRecipe = new Scene(groupUpdateRecipe, 1000, 600);

	}

	public Label getLabel_nameUpdate() {
		return Label_nameUpdate;
	}

	private void init_addRegularRecipe() {
		vbox_AddRegularRecipe = new VBox();
		vbox_AddRegularRecipe.setPrefWidth(1000);
		vbox_AddRegularRecipe.setPrefHeight(600);

		label_AddRegularRecipe = new Label("Add Recipe");
		label_AddRegularRecipe.setPrefWidth(950);
		label_AddRegularRecipe.setPrefHeight(50);

		hbox_label_addRegularRecipe = new HBox();
		hbox_label_addRegularRecipe.setPrefWidth(1000);
		hbox_label_addRegularRecipe.setPrefHeight(50);

		button_BackFromAddRecipeRegular = new Button("Back");
		button_BackFromAddRecipeRegular.setPrefWidth(50);
		button_BackFromAddRecipeRegular.setPrefHeight(50);

		hbox_label_addRegularRecipe.getChildren().addAll(button_BackFromAddRecipeRegular, label_AddRegularRecipe);

		groupAddRegularRecipe = new Group();
		groupAddRegularRecipe.getStylesheets().add(getClass().getResource("/CSS/FullStyle.css").toExternalForm());

		hbox_FormatAddRegularrecipe = new HBox();
		hbox_FormatAddRegularrecipe.setPrefWidth(1000);
		hbox_FormatAddRegularrecipe.setPrefHeight(550);

		Vbox_1THrds = new VBox();

		textField_newRecipeName = new TextField();
		textField_newRecipeName.setPrefWidth(200);
		textField_newRecipeName.setPrefHeight(50);
		textField_newRecipeName.setPromptText("Please enter a recipe name");

		imagwView_addNewRecipeRegular = new ImageView();
		imagwView_addNewRecipeRegular.setFitWidth(200);
		imagwView_addNewRecipeRegular.setFitHeight(200);
		Image image_addRecipeRegular = new Image("/Other/recipe-default-image.png");
		imagwView_addNewRecipeRegular.setImage(image_addRecipeRegular);

		// imagwView_addNewRecipeRegular.getImage();

		button_uploadPhotoAddRecipeRegular = new Button("upload");
		button_uploadPhotoAddRecipeRegular.setPrefWidth(200);
		button_uploadPhotoAddRecipeRegular.setPrefHeight(50);

		button_addNewRecipeRegular = new Button("Add new Recipe");
		button_addNewRecipeRegular.setPrefSize(200, 100);

		Vbox_1THrds.getChildren().addAll(textField_newRecipeName, imagwView_addNewRecipeRegular,
				button_uploadPhotoAddRecipeRegular, button_addNewRecipeRegular);

		// table view ingredients
		init_tableView_ingred();

		// table view steps
		init_tableView_steps();

		hbox_FormatAddRegularrecipe.getChildren().addAll(Vbox_1THrds, Vbox_2THrds, Vbox_3THrds);

		vbox_AddRegularRecipe.getChildren().addAll(hbox_label_addRegularRecipe, hbox_FormatAddRegularrecipe);
		groupAddRegularRecipe.getChildren().addAll(vbox_AddRegularRecipe);
		sceneAddRegularRecipe = new Scene(groupAddRegularRecipe, 1000, 600);
	}

	public Button getButton_addNewRecipeRegular() {
		return button_addNewRecipeRegular;
	}

	public void addNewRegularRecipeEVENT(EventHandler<ActionEvent> event, Button button) {
		button.setOnAction(event);
	}

	public RecipeRegular addNewRegularRecipe(ArrayList<Recipe> recipes) throws EmptyException, ExistsException {

		String name = "";

		if (textField_newRecipeName.getText() == "") {
			throw new EmptyException();
		} else {
			for (Recipe recipe : recipes) {
				if (recipe.getRecipeName().equals(textField_newRecipeName.getText())) {
					throw new ExistsException();
				}
			}
			name = textField_newRecipeName.getText();
		}

		RecipeRegular rp = new RecipeRegular(name, tableView_addIngr.getItems(), tableView_addsteps.getItems(),
				imagwView_addNewRecipeRegular.getImage());
		textField_newRecipeName.clear();
		tableView_addIngr.getItems().clear();
		tableView_addsteps.getItems().clear();
		return rp;
	}

	@SuppressWarnings("unchecked")
	private void init_tableView_steps() {

		Vbox_3THrds = new VBox();
		Vbox_3THrds.setPrefWidth(400);

		label_addRegular_steps = new Label("Steps");
		label_addRegular_steps.setPrefWidth(400);
		label_addRegular_steps.getStylesheets().add(getClass().getResource("/CSS/LabelView.css").toExternalForm());
		tableView_addsteps = new TableView<Step>();
		tableView_addsteps.getStylesheets().add(getClass().getResource("/CSS/Table.css").toExternalForm());
		tableView_addsteps.setPrefSize(400, 500);
		// tableView_addsteps.setEditable(true);

		stepsNum = new TableColumn<Step, Integer>("num");
		stepsNum.setCellValueFactory(new PropertyValueFactory<Step, Integer>("num"));
		stepsNum.setPrefWidth(50);
		stepsStep = new TableColumn<Step, String>("step");
		stepsStep.setCellValueFactory(new PropertyValueFactory<Step, String>("step"));
		stepsStep.setPrefWidth(350);
		tableView_addsteps.getColumns().addAll(stepsNum, stepsStep);

		HBox_steps_textField = new HBox();
		TextField_StepNUM = new TextField();
		TextField_StepNUM.setPromptText("Num");
		TextField_StepNUM.setPrefWidth(50);
		TextField_Step = new TextField();
		TextField_Step.setPromptText("Step");
		TextField_Step.setPrefWidth(350);

		HBox_steps_textField.getChildren().addAll(TextField_StepNUM, TextField_Step);

		button_AddStep = new Button("Add Step");
		button_AddStep.setPrefWidth(400);

		Vbox_3THrds.getChildren().addAll(label_addRegular_steps, tableView_addsteps, HBox_steps_textField,
				button_AddStep);
	}

	public void addNewStepEVENT(EventHandler<ActionEvent> event, Button button) {
		button.setOnAction(event);
	}

	public void addStep() throws EmptyException, InValidInputException, ExistsException {
		ObservableList<Step> stepsListView = tableView_addsteps.getItems();
		String step = "";
		int num = 0;
		if (TextField_Step.getText() == "")
			throw new EmptyException();
		else {
			step = TextField_Step.getText();
		}
		if (TextField_StepNUM.getText() == "")
			throw new EmptyException();
		else {
			if (Integer.valueOf((TextField_StepNUM.getText())) < 1) {
				throw new InValidInputException();
			} else {
				for (Step Step : stepsListView) {
					if (Integer.valueOf((TextField_StepNUM.getText())) == Step.getNum()) {
						throw new ExistsException();
					}
				}
				num = Integer.valueOf((TextField_StepNUM.getText()));
			}
		}
		TextField_Step.clear();
		TextField_StepNUM.clear();
		stepsListView.add(new Step(num, step));
		tableView_addsteps.setItems(stepsListView);
	}

	@SuppressWarnings("unchecked")
	private void init_tableView_ingred() {
		Vbox_2THrds = new VBox();
		Vbox_2THrds.setPrefWidth(400);

		label_addRegular_Ingredients = new Label("Ingredients");
		label_addRegular_Ingredients.setPrefWidth(400);
		label_addRegular_Ingredients.getStylesheets()
				.add(getClass().getResource("/CSS/LabelView.css").toExternalForm());

		tableView_addIngr = new TableView<Ingredient>();
		tableView_addIngr.getStylesheets().add(getClass().getResource("/CSS/Table.css").toExternalForm());
		tableView_addIngr.setPrefSize(400, 600);
		tableView_addIngr.setEditable(true);

		ingredientName = new TableColumn<Ingredient, String>("Name");
		ingredientName.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("ingredientName"));
		ingredientName.setPrefWidth(400 / 3);

		ingredientAmount = new TableColumn<Ingredient, Double>("Amount");
		ingredientAmount.setCellValueFactory(new PropertyValueFactory<Ingredient, Double>("ingredientAmount"));
		ingredientAmount.setPrefWidth(400 / 3);

		ingredientWeightType = new TableColumn<Ingredient, String>("Type");
		ingredientWeightType.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("ingredientWeightType"));
		ingredientWeightType.setPrefWidth(400 / 3);

		tableView_addIngr.getColumns().addAll(ingredientName, ingredientAmount, ingredientWeightType);
		Hbox_TextFieldsING = new HBox();

		TextField_IngName = new TextField();
		TextField_IngName.setPromptText("Name");
		TextField_IngAmount = new TextField();
		TextField_IngAmount.setPromptText("Amount");

		comboBox_ingType = new ComboBox<String>();
		comboBox_ingType.getItems().addAll(intTypeArray);

		button_AddIng = new Button("Add Ingredient");
		button_AddIng.setPrefWidth(400);
		Hbox_TextFieldsING.getChildren().addAll(TextField_IngName, TextField_IngAmount, comboBox_ingType);
		Vbox_2THrds.getChildren().addAll(label_addRegular_Ingredients, tableView_addIngr, Hbox_TextFieldsING,
				button_AddIng);
	}

	public void addNewIngEVENT(EventHandler<ActionEvent> event, Button button) {
		button.setOnAction(event);
	}

	public void addIngred() throws EmptyException, InValidInputException, ExistsException {
		ObservableList<Ingredient> ingredientsList = tableView_addIngr.getItems();
		tableView_addIngr.setItems(ingredientsList);

		String name = "";
		double amount = 0;
		String type = "";
		if (TextField_IngName.getText() == "") {
			throw new EmptyException();
		} else {
			for (Ingredient ingredient : ingredientsList) {
				if (TextField_IngName.getText().equalsIgnoreCase(ingredient.getIngredientName())) {
					throw new ExistsException();
				}
			}
			name = TextField_IngName.getText();
		}

		if (TextField_IngAmount.getText() == "") {
			throw new EmptyException();
		} else {
			if (Double.valueOf(TextField_IngAmount.getText()) <= 0) {
				throw new InValidInputException();
			} else {
				amount = Double.valueOf(TextField_IngAmount.getText());

			}
		}
		if (comboBox_ingType.getValue() == null) {
			throw new EmptyException();
		} else {
			type = comboBox_ingType.getValue();
		}

		Ingredient ing = new Ingredient(name, amount, type);
		ingredientsList.add(ing);

		TextField_IngName.clear();
		TextField_IngAmount.clear();
		comboBox_ingType.setValue(null);
	}

	private void init_profile() {
		vbox_Profile = new VBox();

		label_Profile = new Label("Profile");
		label_Profile.setPrefWidth(1000);
		label_Profile.setPrefHeight(100);

		profile_ToolBar = new HBox();
		button_AllRecipes_inProfile = new Button("AllReciepes");
		button_AllRecipes_inProfile.setPrefSize(200, 50);
		buttonFavoriets_inProfile = new Button("Favoriets");
		buttonFavoriets_inProfile.setPrefSize(200, 50);
		buttonSearch_inProfile = new Button("Search");
		buttonSearch_inProfile.setPrefSize(200, 50);
		buttonWeb_inProfile = new Button("Web");
		buttonWeb_inProfile.setPrefSize(200, 50);
		buttonInfo_inProfile = new Button("Profile");
		buttonInfo_inProfile.setPrefSize(200, 50);

		groupProfile = new Group();
		groupProfile.getStylesheets().add(getClass().getResource("/CSS/FullStyle.css").toExternalForm());

		profile_ToolBar.getChildren().addAll(button_AllRecipes_inProfile, buttonFavoriets_inProfile,
				buttonSearch_inProfile, buttonWeb_inProfile, buttonInfo_inProfile);
		vbox_Profile.getChildren().addAll(label_Profile, profile_ToolBar);
		groupProfile.getChildren().addAll(vbox_Profile);
		sceneProfile = new Scene(groupProfile, 1000, 600);
	}

	private void init_webView() {
		vbox_Web = new VBox();

		label_Web = new Label("Web");
		label_Web.setPrefWidth(1000);
		label_Web.setPrefHeight(75);

		Hbox_SearchField_Web = new HBox();

		textField_webSearch = new TextField();
		textField_webSearch.setPrefWidth(800);
		textField_webSearch.setPrefHeight(25);

		textField_web_name = new TextField();
		textField_web_name.setPrefWidth(800);
		textField_web_name.setPrefHeight(25);
		textField_web_name.setPromptText("Please enter the name of the recipe");

		button_SearchFromWebAddress = new Button("Search");
		button_SearchFromWebAddress.setPrefSize(200, 25);

		// webView
		webView_SearchRecipe = new WebView();
		webEngin_SearchRecipe = new WebEngine();
		webEngin_SearchRecipe = webView_SearchRecipe.getEngine();
		textField_webSearch.setText("www.seriouseats.com");
		loadPage();
		webView_SearchRecipe.setPrefWidth(1000);
		webView_SearchRecipe.setPrefHeight(400);

		//
		Hbox_SearchField_Web.getChildren().addAll(textField_webSearch, button_SearchFromWebAddress);

		button_addlinkRecipe = new Button("Add new recipe");
		button_addlinkRecipe.setPrefWidth(1000);
		button_addlinkRecipe.setPrefHeight(25);

		web_ToolBar = new HBox();
		button_AllRecipes_inWeb = new Button("AllReciepes");
		button_AllRecipes_inWeb.setPrefSize(250, 50);
		buttonFavoriets_inWeb = new Button("Favoriets");
		buttonFavoriets_inWeb.setPrefSize(250, 50);
		buttonSearch_inWeb = new Button("Search");
		buttonSearch_inWeb.setPrefSize(250, 50);
		buttonWeb_inWeb = new Button("Web");
		buttonWeb_inWeb.setPrefSize(250, 50);
		buttonInfo_inWeb = new Button("Profile");
		buttonInfo_inWeb.setPrefSize(200, 50);

		groupWeb = new Group();
		groupWeb.getStylesheets().add(getClass().getResource("/CSS/FullStyle.css").toExternalForm());

		web_ToolBar.getChildren().addAll(button_AllRecipes_inWeb, buttonFavoriets_inWeb, buttonSearch_inWeb,
				buttonWeb_inWeb);
		vbox_Web.getChildren().addAll(label_Web, Hbox_SearchField_Web, webView_SearchRecipe, textField_web_name,
				button_addlinkRecipe, web_ToolBar);
		groupWeb.getChildren().addAll(vbox_Web);
		sceneWeb = new Scene(groupWeb, 1000, 600);
	}

	private void init_search() {
		vbox_search = new VBox();

		label_Search = new Label("Search");
		label_Search.setPrefWidth(1000);
		label_Search.setPrefHeight(100);

		textField_search = new TextField();
		textField_search.setPrefWidth(900);
		textField_search.setPrefHeight(50);
		hbox_searchBar = new HBox();

		button_Search = new Button("Search");
		button_Search.setPrefSize(100, 50);

		hbox_searchBar.getChildren().addAll(textField_search, button_Search);
		searchListView = new ListView<String>();
		searchListView.setPrefWidth(1000);
		searchListView.setPrefHeight(400);

		search_ToolBar = new HBox();
		button_AllRecipes_inSearch = new Button("AllReciepes");
		button_AllRecipes_inSearch.setPrefSize(250, 50);
		buttonFavoriets_inSearch = new Button("Favoriets");
		buttonFavoriets_inSearch.setPrefSize(250, 50);
		buttonSearch_inSearch = new Button("Search");
		buttonSearch_inSearch.setPrefSize(250, 50);
		buttonWeb_inSearch = new Button("Web");
		buttonWeb_inSearch.setPrefSize(250, 50);
		buttonInfo_inSearch = new Button("Profile");
		buttonInfo_inSearch.setPrefSize(200, 50);

		groupSearch = new Group();
		groupSearch.getStylesheets().add(getClass().getResource("/CSS/FullStyle.css").toExternalForm());

		search_ToolBar.getChildren().addAll(button_AllRecipes_inSearch, buttonFavoriets_inSearch, buttonSearch_inSearch,
				buttonWeb_inSearch);
		vbox_search.getChildren().addAll(label_Search, hbox_searchBar, searchListView, search_ToolBar);
		groupSearch.getChildren().addAll(vbox_search);
		setSceneSearch(new Scene(groupSearch, 1000, 600));
	}

	public void search(ArrayList<Recipe> recipes) throws EmptyException {
		// textField_search
		searchListView.getItems().clear();
		String name = "";
		if (textField_search.getText() == "") {
			throw new EmptyException();
		} else {

			name = textField_search.getText();
		}

		for (Recipe recipe : recipes) {
			if (recipe.getRecipeName().equalsIgnoreCase(name)
					|| recipe.getRecipeName().toLowerCase().contains(name.toLowerCase())) {
				searchListView.getItems().add(recipe.getRecipeName());
			} else {

				if (recipe instanceof RecipeRegular) {
					for (Ingredient ing : ((RecipeRegular) recipe).getIngredients()) {
						if (ing.getIngredientName().equalsIgnoreCase(name)
								|| ing.getIngredientName().toLowerCase().contains(name.toLowerCase())) {
							searchListView.getItems().add(recipe.getRecipeName());
							break;
						}
					}
				}
			}
		}

	}

	private void init_favorites() {
		vbox_Favorites = new VBox();
		label_Favorites = new Label("Favorites");
		label_Favorites.setPrefWidth(1000);
		label_Favorites.setPrefHeight(100);

		favoriets_Formating = new HBox();
		favoriets_Formating.setPrefWidth(1000);
		favoriets_Formating.setPrefHeight(450);

		favoritesListView = new ListView<String>();
		favoritesListView.setPrefWidth(500);
		favoritesListView.setPrefHeight(450);

		favoriets_ToolBar = new HBox();
		favoriets_ToolBar.setPrefWidth(1000);
		favoriets_ToolBar.setPrefHeight(50);

		VBOX_ViewRergularRecipe_favorite = new VBox();
		VBOX_ViewRergularRecipe_favorite.setPrefWidth(500);
		VBOX_ViewRergularRecipe_favorite.setPrefHeight(450);

		label_RecipeName_favorite = new Label("Recipe name");
		label_RecipeName_favorite.setPrefWidth(500);
		label_RecipeName_favorite.setPrefHeight(50);
		label_RecipeName_favorite.getStylesheets().add(getClass().getResource("/CSS/MainLabel.css").toExternalForm());

		label_Ingredients_favorite = new Label("Ingredients:");
		label_Ingredients_favorite.setPrefWidth(500);
		label_Ingredients_favorite.setPrefHeight(25);
		label_Ingredients_favorite.getStylesheets().add(getClass().getResource("/CSS/LabelView.css").toExternalForm());

		textArea_ingredients_favorite = new TextArea();
		textArea_ingredients_favorite.setEditable(false);
		textArea_ingredients_favorite.setPrefWidth(500);
		textArea_ingredients_favorite.setPrefHeight(200);

		label_Steps_favorite = new Label("Steps:");
		label_Steps_favorite.setPrefWidth(500);
		label_Steps_favorite.setPrefHeight(25);
		label_Steps_favorite.getStylesheets().add(getClass().getResource("/CSS/LabelView.css").toExternalForm());

		textArea_Steps_favorite = new TextArea();
		textArea_Steps_favorite.setEditable(false);
		textArea_Steps_favorite.setPrefWidth(500);
		textArea_Steps_favorite.setPrefHeight(200);

		stackPane_favorites = new StackPane();
		favoritesWebview = new WebView();
		favoritesWebEngin = new WebEngine();
		favoritesWebEngin = favoritesWebview.getEngine();
		stackPane_favorites.setTranslateX(500);
		stackPane_favorites.setTranslateY(140);
		stackPane_favorites.setPrefSize(500, 400);
		stackPane_favorites.setVisible(false);

		stackPane_favorites.getChildren().addAll(favoritesWebview);

		VBOX_ViewRergularRecipe_favorite.getChildren().addAll(label_RecipeName_favorite, label_Ingredients_favorite,
				textArea_ingredients_favorite, label_Steps_favorite, textArea_Steps_favorite);
		favoriets_Formating.getChildren().addAll(favoritesListView, VBOX_ViewRergularRecipe_favorite);

		button_AllRecipes_inFav = new Button("AllReciepes");
		button_AllRecipes_inFav.setPrefSize(250, 50);
		buttonFavoriets_inFav = new Button("Favoriets");
		buttonFavoriets_inFav.setPrefSize(250, 50);
		buttonSearch_inFav = new Button("Search");
		buttonSearch_inFav.setPrefSize(250, 50);
		buttonWeb_inFav = new Button("Web");
		buttonWeb_inFav.setPrefSize(250, 50);
		buttonInfo_inFav = new Button("Profile");
		buttonInfo_inFav.setPrefSize(200, 50);

		groupFavoriets = new Group();
		groupFavoriets.getStylesheets().add(getClass().getResource("/CSS/FullStyle.css").toExternalForm());

		favoriets_ToolBar.getChildren().addAll(button_AllRecipes_inFav, buttonFavoriets_inFav, buttonSearch_inFav,
				buttonWeb_inFav);
		vbox_Favorites.getChildren().addAll(label_Favorites, favoriets_Formating, favoriets_ToolBar);
		groupFavoriets.getChildren().addAll(vbox_Favorites, stackPane_favorites);
		sceneFavoriets = new Scene(groupFavoriets, 1000, 600);
	}

	public void setRecipeView_Favorite(Recipe recipe) {
		label_RecipeName_favorite.setText(recipe.getRecipeName());
		if (recipe instanceof RecipeRegular) {
			stackPane_favorites.setVisible(false);
			textArea_ingredients_favorite.setText(((RecipeRegular) recipe).printIng());
			textArea_Steps_favorite.setText(((RecipeRegular) recipe).printStep());
		} else if (recipe instanceof RecipeLink) {
			stackPane_favorites.setVisible(true);
			loadPageFromText(favoritesWebEngin, ((RecipeLink) recipe).getLink());
		} else {
			textArea_ingredients_allRecipes.clear();
			textArea_Steps_allRecipes.clear();
			stackPane_viewRecipe.setVisible(false);
		}
	}

	private void init_allRecipes() {
		VBox_allRecipes = new VBox();
		label_AllRecipes = new Label("All recipes");
		label_AllRecipes.setPrefWidth(1000);
		label_AllRecipes.setPrefHeight(100);

		hBox_format_table_AllRecipes = new HBox();
		hBox_format_table_AllRecipes.setPrefWidth(1000);
		hBox_format_table_AllRecipes.setPrefHeight(450);

		allRecipesListView = new ListView<String>();
		allRecipesListView.setPrefWidth(500);
		allRecipesListView.setPrefHeight(450);

		// view regular recipe
		VBOX_ViewRergularRecipe = new VBox();
		VBOX_ViewRergularRecipe.setPrefWidth(500);
		VBOX_ViewRergularRecipe.setPrefHeight(450);

		HBox_headlineRecipeViewALl = new HBox();

		label_RecipeName_AllRecipes = new Label("Recipe name");
		label_RecipeName_AllRecipes.setPrefWidth(375);
		label_RecipeName_AllRecipes.setPrefHeight(50);
		label_RecipeName_AllRecipes.getStylesheets().add(getClass().getResource("/CSS/MainLabel.css").toExternalForm());

		checkBox_sceneAll = new CheckBox();
		checkBox_sceneAll.setText(" Favorite");
		HBox_headlineRecipeViewALl.getChildren().addAll(label_RecipeName_AllRecipes, checkBox_sceneAll);

		label_Ingredients_AllRecipes = new Label("Ingredients:");
		label_Ingredients_AllRecipes.setPrefWidth(300);
		label_Ingredients_AllRecipes.setPrefHeight(25);
		label_Ingredients_AllRecipes.getStylesheets()
				.add(getClass().getResource("/CSS/LabelView.css").toExternalForm());
		Vbox_labelIng = new VBox();
		Hbox_imageAllRecipes = new HBox();

		textArea_ingredients_allRecipes = new TextArea();
		textArea_ingredients_allRecipes.setEditable(false);
		textArea_ingredients_allRecipes.setPrefSize(300, 200);
		textArea_ingredients_allRecipes.setWrapText(true);
		Vbox_labelIng.getChildren().addAll(label_Ingredients_AllRecipes, textArea_ingredients_allRecipes);

		Vbox_imageView_Delete = new VBox();
		ImageView_AllRecipes = new ImageView();
		ImageView_AllRecipes.prefWidth(200);
		ImageView_AllRecipes.prefHeight(200);
		ImageView_AllRecipes.setFitWidth(200);
		ImageView_AllRecipes.setFitHeight(200);

		Vbox_imageView_Delete.getChildren().addAll(ImageView_AllRecipes);
		Hbox_imageAllRecipes.getChildren().addAll(Vbox_labelIng, Vbox_imageView_Delete);
		Hbox_imageAllRecipes.setPrefSize(500, 200);

		label_Steps_AllRecipes = new Label("Steps:");
		label_Steps_AllRecipes.setPrefWidth(500);
		label_Steps_AllRecipes.setPrefHeight(25);
		label_Steps_AllRecipes.getStylesheets().add(getClass().getResource("/CSS/LabelView.css").toExternalForm());

		Hbox_DEL_UPDATE = new HBox();
		Vbox_DEL_UPDATE = new VBox();
		button_delete = new Button("Delete");
		button_delete.setPrefSize(50, 200 / 3);
		button_Update = new Button("Edit");
		button_Update.setPrefSize(50, 200 / 3);
		button_addRecipeRegular = new Button("Add");
		button_addRecipeRegular.setPrefSize(50, 200 / 3);
		Vbox_DEL_UPDATE.getChildren().addAll(button_delete, button_addRecipeRegular, button_Update);

		textArea_Steps_allRecipes = new TextArea();
		textArea_Steps_allRecipes.setEditable(false);
		textArea_Steps_allRecipes.setPrefWidth(450);
		textArea_Steps_allRecipes.setPrefHeight(200);
		textArea_Steps_allRecipes.setWrapText(true);
		Hbox_DEL_UPDATE.getChildren().addAll(textArea_Steps_allRecipes, Vbox_DEL_UPDATE);

		VBOX_ViewRergularRecipe.getChildren().addAll(HBox_headlineRecipeViewALl, label_Ingredients_AllRecipes,
				Hbox_imageAllRecipes, label_Steps_AllRecipes, Hbox_DEL_UPDATE);
		hBox_format_table_AllRecipes.getChildren().addAll(allRecipesListView, VBOX_ViewRergularRecipe);

		allRecipes_ToolBar = new HBox();
		allRecipes_ToolBar.setPrefWidth(1000);
		allRecipes_ToolBar.setPrefHeight(50);

		button_AllRecipes_inAll = new Button("AllReciepes");
		button_AllRecipes_inAll.setPrefSize(250, 50);
		buttonFavoriets_inAll = new Button("Favoriets");
		buttonFavoriets_inAll.setPrefSize(250, 50);
		buttonSearch_inAll = new Button("Search");
		buttonSearch_inAll.setPrefSize(250, 50);
		buttonWeb_inAll = new Button("Web");
		buttonWeb_inAll.setPrefSize(250, 50);
		buttonInfo_inAll = new Button("Profile");
		buttonInfo_inAll.setPrefSize(200, 50);

		stackPane_viewRecipe = new StackPane();
		stackPane_viewRecipe.setPrefWidth(450);
		stackPane_viewRecipe.setPrefHeight(420);
		stackPane_viewRecipe.setTranslateX(500);
		stackPane_viewRecipe.setTranslateY(130);
		webView_ViewRecipeLink = new WebView();
		webEngin_ViewRecipeLink = new WebEngine();
		webEngin_ViewRecipeLink = webView_ViewRecipeLink.getEngine();
		loadPageFromText(webEngin_ViewRecipeLink, "www.google.com");
		stackPane_viewRecipe.getChildren().addAll(webView_ViewRecipeLink);
		stackPane_viewRecipe.setVisible(false);

		groupAllRecipes = new Group();
		groupAllRecipes.getStylesheets().add(getClass().getResource("/CSS/FullStyle.css").toExternalForm());
		allRecipes_ToolBar.getChildren().addAll(button_AllRecipes_inAll, buttonFavoriets_inAll, buttonSearch_inAll,
				buttonWeb_inAll);
		VBox_allRecipes.getChildren().addAll(label_AllRecipes, hBox_format_table_AllRecipes, allRecipes_ToolBar);
		groupAllRecipes.getChildren().addAll(VBox_allRecipes, stackPane_viewRecipe);
		sceneAll = new Scene(groupAllRecipes, 1000, 600);
	}

	public Button getButton_Update() {
		return button_Update;
	}

	public Button getButton_delete() {
		return button_delete;
	}

	private void init_startMenu() {
		groupInitProgram = new Group();

		Vbox_initProgram = new VBox();
		label_initProgram = new Label("Welcome to the  your Cooking Book");
		label_initProgram.setPrefSize(1000, 300);

		label_userName = new Label("Please enter userName");
		label_userName.setPrefWidth(1000);
		label_userName.getStylesheets().add(getClass().getResource("/CSS/LabelView.css").toExternalForm());

		label_password = new Label("Please enter password");
		label_password.setPrefWidth(1000);
		label_password.getStylesheets().add(getClass().getResource("/CSS/LabelView.css").toExternalForm());

		Button_initProgram = new Button("Start");
		Button_initProgram.setPrefSize(1000, 50);

		groupInitProgram.getStylesheets().add(getClass().getResource("/CSS/FullStyle.css").toExternalForm());
		Vbox_initProgram.getChildren().addAll(label_initProgram, Button_initProgram);
		groupInitProgram.getChildren().add(Vbox_initProgram);
		SceneInitProgram = new Scene(groupInitProgram, 1000, 600);
	}

	public void loadPage() {
		String page = "";
		if (textField_webSearch.getText() == "") {
			initAlert("Web address is ampty", AlertType.ERROR);
		} else {
			page = textField_webSearch.getText();
		}

		webEngin_SearchRecipe.load("http://" + page);
	}

	public void loadPageFromText(WebEngine engin, String string) {
		engin.load("http://" + string);
	}

	// set new image
	public void setImage(ActionEvent event, ImageView ImageView) {
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Change Image");

		// filter .jpg
		ExtensionFilter imageFilter = new ExtensionFilter("Image files", "*.jpg", "*.png");
		fileChooser.getExtensionFilters().add(imageFilter);

		// make file chooser visible
		File ProfileImage = fileChooser.showOpenDialog(stage);

		if (ProfileImage != null && ProfileImage.isFile()) {
			ImageView.setImage(new Image(ProfileImage.toURI().toString()));
		}

	}

	// add name to list view
	public void setList(ArrayList<Recipe> list) {
		for (Recipe recipe : list) {
			allRecipesListView.getItems().add(recipe.getRecipeName());
		}
	}

	public void setListFavorite(ArrayList<Recipe> list) {
		for (Recipe recipe : list) {
			if (recipe.isFavorite()) {
				favoritesListView.getItems().add(recipe.getRecipeName());
			}
		}
	}

	public void setRecipeView_ALL(Recipe recipe) {
		label_RecipeName_AllRecipes.setText(recipe.getRecipeName());
		if (recipe instanceof RecipeRegular) {
			button_Update.setVisible(true);
			checkBox_sceneAll.setSelected(recipe.isFavorite());
			textArea_ingredients_allRecipes.setText(((RecipeRegular) recipe).printIng());
			stackPane_viewRecipe.setVisible(false);
			textArea_Steps_allRecipes.setText(((RecipeRegular) recipe).printStep());
			ImageView_AllRecipes.setImage(((RecipeRegular) recipe).getImage());
		} else if (recipe instanceof RecipeLink) {
			button_Update.setVisible(false);
			checkBox_sceneAll.setSelected(recipe.isFavorite());
			textArea_ingredients_allRecipes.setText(((RecipeLink) recipe).getLink());
			textArea_Steps_allRecipes.setText(((RecipeLink) recipe).getLink());
			stackPane_viewRecipe.setVisible(true);
			loadPageFromText(webEngin_ViewRecipeLink, "" + ((RecipeLink) recipe).getLink());
		} else {
			textArea_ingredients_allRecipes.clear();
			textArea_Steps_allRecipes.clear();
			stackPane_viewRecipe.setVisible(false);
		}
	}

/////////////////////////////////////////////////////////
//				add  new recipe Link		
/////////////////////////////////////////////////////////

	public void addNewRecipeLinkEVENT(EventHandler<ActionEvent> event, Button button) {
		button.setOnAction(event);
	}

	public RecipeLink addNewRecipeLink() throws EmptyException {
		String name = "";

		if (textField_web_name.getText() == "") {
			throw new EmptyException();
		} else {
			name = textField_web_name.getText();
		}

		loadPageFromText(webEngin_ViewRecipeLink, "www.google.com");

		allRecipesListView.getItems().clear();
		RecipeLink recipeLink = new RecipeLink(name, webView_SearchRecipe.getEngine().getLocation().substring(7));
		return recipeLink;
	}

/////////////////////////////////////////////////////////
//				change scences
/////////////////////////////////////////////////////////

	public void changeScene(EventHandler<ActionEvent> event, Button button) {
		button.setOnAction(event);
	}

	public void setScene(Scene scene) {
		stage.setScene(scene);
	}

/////////////////////////////////////////////////////////
//                    gettes and setters
/////////////////////////////////////////////////////////
	public Button getButton_AddStep() {
		return button_AddStep;
	}

	public ListView<String> getAllRecipesListView() {
		return allRecipesListView;
	}

	public void setAllRecipesListView(ListView<String> allRecipesListView) {
		this.allRecipesListView = allRecipesListView;
	}

	public Button getButtonFavoriets_inAll() {
		return buttonFavoriets_inAll;
	}

	public void setButtonFavoriets_inAll(Button buttonFavoriets_inAll) {
		this.buttonFavoriets_inAll = buttonFavoriets_inAll;
	}

	public Stage getStage() {
		return stage;
	}

	public Group getGroupAllRecipes() {
		return groupAllRecipes;
	}

	public Scene getSceneAll() {
		return sceneAll;
	}

	public VBox getVBox_allRecipes() {
		return VBox_allRecipes;
	}

	public Button getButton_AllRecipes_inAll() {
		return button_AllRecipes_inAll;
	}

	public Button getButtonSearch_inAll() {
		return buttonSearch_inAll;
	}

	public Button getButtonWeb_inFav() {
		return buttonWeb_inFav;
	}

	public Button getButtonInfo_inAll() {
		return buttonInfo_inAll;
	}

	public Label getLabel_AllRecipes() {
		return label_AllRecipes;
	}

	public Group getGroupFavoriets() {
		return groupFavoriets;
	}

	public Label getLabel_Favorites() {
		return label_Favorites;
	}

	public VBox getVbox_Favorites() {
		return vbox_Favorites;
	}

	public ListView<String> getFavoritesListView() {
		return favoritesListView;
	}

	public HBox getAllRecipes_ToolBar() {
		return allRecipes_ToolBar;
	}

	public HBox getFavoriets_ToolBar() {
		return favoriets_ToolBar;
	}

	public Button getButtonWeb_inAll() {
		return buttonWeb_inAll;
	}

	public Button getButton_AllRecipes_inFav() {
		return button_AllRecipes_inFav;
	}

	public Button getButtonInfo_inFav() {
		return buttonInfo_inFav;
	}

	public Button getButtonSearch_inFav() {
		return buttonSearch_inFav;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setGroupAllRecipes(Group groupAllRecipes) {
		this.groupAllRecipes = groupAllRecipes;
	}

	public void setSceneAll(Scene sceneAll) {
		this.sceneAll = sceneAll;
	}

	public void setVBox_allRecipes(VBox vBox_allRecipes) {
		VBox_allRecipes = vBox_allRecipes;
	}

	public void setButton_AllRecipes_inAll(Button button_AllRecipes_inAll) {
		this.button_AllRecipes_inAll = button_AllRecipes_inAll;
	}

	public void setButtonSearch_inAll(Button buttonSearch_inAll) {
		this.buttonSearch_inAll = buttonSearch_inAll;
	}

	public void setButtonWeb_inFav(Button buttonWeb_inFav) {
		this.buttonWeb_inFav = buttonWeb_inFav;
	}

	public void setButtonInfo_inAll(Button buttonInfo_inAll) {
		this.buttonInfo_inAll = buttonInfo_inAll;
	}

	public void setLabel_AllRecipes(Label label_AllRecipes) {
		this.label_AllRecipes = label_AllRecipes;
	}

	public void setGroupFavoriets(Group groupFavoriets) {
		this.groupFavoriets = groupFavoriets;
	}

	public void setLabel_Favorites(Label label_Favorites) {
		this.label_Favorites = label_Favorites;
	}

	public void setVbox_Favorites(VBox vbox_Favorites) {
		this.vbox_Favorites = vbox_Favorites;
	}

	public void setFavoritesListView(ListView<String> favoritesListView) {
		this.favoritesListView = favoritesListView;
	}

	public void setAllRecipes_ToolBar(HBox allRecipes_ToolBar) {
		this.allRecipes_ToolBar = allRecipes_ToolBar;
	}

	public void setFavoriets_ToolBar(HBox favoriets_ToolBar) {
		this.favoriets_ToolBar = favoriets_ToolBar;
	}

	public void setButtonWeb_inAll(Button buttonWeb_inAll) {
		this.buttonWeb_inAll = buttonWeb_inAll;
	}

	public void setButton_AllRecipes_inFav(Button button_AllRecipes_inFav) {
		this.button_AllRecipes_inFav = button_AllRecipes_inFav;
	}

	public void setButtonInfo_inFav(Button buttonInfo_inFav) {
		this.buttonInfo_inFav = buttonInfo_inFav;
	}

	public void setButtonSearch_inFav(Button buttonSearch_inFav) {
		this.buttonSearch_inFav = buttonSearch_inFav;
	}

	public Scene getSceneFavoriets() {
		return sceneFavoriets;
	}

	public void setSceneFavoriets(Scene sceneFavoriets) {
		this.sceneFavoriets = sceneFavoriets;
	}

	public Scene getSceneSearch() {
		return sceneSearch;
	}

	public void setSceneSearch(Scene sceneSearch) {
		this.sceneSearch = sceneSearch;
	}

	public Group getGroupSearch() {
		return groupSearch;
	}

	public VBox getVbox_search() {
		return vbox_search;
	}

	public HBox getSearch_ToolBar() {
		return search_ToolBar;
	}

	public Button getButton_AllRecipes_inSearch() {
		return button_AllRecipes_inSearch;
	}

	public Button getButtonWeb_inSearch() {
		return buttonWeb_inSearch;
	}

	public Button getButtonSearch_inSearch() {
		return buttonSearch_inSearch;
	}

	public TextField getTextField() {
		return textField_search;
	}

	public Label getLabel_Search() {
		return label_Search;
	}

	public ListView<String> getSearchListView() {
		return searchListView;
	}

	public void setGroupSearch(Group groupSearch) {
		this.groupSearch = groupSearch;
	}

	public void setVbox_search(VBox vbox_search) {
		this.vbox_search = vbox_search;
	}

	public void setSearch_ToolBar(HBox search_ToolBar) {
		this.search_ToolBar = search_ToolBar;
	}

	public void setButton_AllRecipes_inSearch(Button button_AllRecipes_inSearch) {
		this.button_AllRecipes_inSearch = button_AllRecipes_inSearch;
	}

	public void setButtonWeb_inSearch(Button buttonWeb_inSearch) {
		this.buttonWeb_inSearch = buttonWeb_inSearch;
	}

	public void setButtonSearch_inSearch(Button buttonSearch_inSearch) {
		this.buttonSearch_inSearch = buttonSearch_inSearch;
	}

	public void setTextField(TextField textField) {
		this.textField_search = textField;
	}

	public void setLabel_Search(Label label_Search) {
		this.label_Search = label_Search;
	}

	public void setSearchListView(ListView<String> searchListView) {
		this.searchListView = searchListView;
	}

	public void setButtonInfo_inSearch(Button buttonInfo_inSearch) {
		this.buttonInfo_inSearch = buttonInfo_inSearch;
	}

	public Button getButtonFavoriets_inFav() {
		return buttonFavoriets_inFav;
	}

	public Button getButtonFavoriets_inSearch() {
		return buttonFavoriets_inSearch;
	}

	public Button getButtonInfo_inSearch() {
		return buttonInfo_inSearch;
	}

	public void setButtonFavoriets_inFav(Button buttonFavoriets_inFav) {
		this.buttonFavoriets_inFav = buttonFavoriets_inFav;
	}

	public void setButtonFavoriets_inSearch(Button buttonFavoriets_inSearch) {
		this.buttonFavoriets_inSearch = buttonFavoriets_inSearch;
	}

	public TextField getTextField_search() {
		return textField_search;
	}

	public VBox getVbox_Web() {
		return vbox_Web;
	}

	public Label getLabel_Web() {
		return label_Web;
	}

	public HBox getWeb_ToolBar() {
		return web_ToolBar;
	}

	public Button getButton_AllRecipes_inWeb() {
		return button_AllRecipes_inWeb;
	}

	public Button getButtonFavoriets_inWeb() {
		return buttonFavoriets_inWeb;
	}

	public Button getButtonSearch_inWeb() {
		return buttonSearch_inWeb;
	}

	public Button getButtonWeb_inWeb() {
		return buttonWeb_inWeb;
	}

	public Button getButtonInfo_inWeb() {
		return buttonInfo_inWeb;
	}

	public Group getGroupWeb() {
		return groupWeb;
	}

	public void setTextField_search(TextField textField_search) {
		this.textField_search = textField_search;
	}

	public void setVbox_Web(VBox vbox_Web) {
		this.vbox_Web = vbox_Web;
	}

	public void setLabel_Web(Label label_Web) {
		this.label_Web = label_Web;
	}

	public void setWeb_ToolBar(HBox web_ToolBar) {
		this.web_ToolBar = web_ToolBar;
	}

	public void setButton_AllRecipes_inWeb(Button button_AllRecipes_inWeb) {
		this.button_AllRecipes_inWeb = button_AllRecipes_inWeb;
	}

	public void setButtonFavoriets_inWeb(Button buttonFavoriets_inWeb) {
		this.buttonFavoriets_inWeb = buttonFavoriets_inWeb;
	}

	public void setButtonSearch_inWeb(Button buttonSearch_inWeb) {
		this.buttonSearch_inWeb = buttonSearch_inWeb;
	}

	public void setButtonWeb_inWeb(Button buttonWeb_inWeb) {
		this.buttonWeb_inWeb = buttonWeb_inWeb;
	}

	public void setButtonInfo_inWeb(Button buttonInfo_inWeb) {
		this.buttonInfo_inWeb = buttonInfo_inWeb;
	}

	public void setGroupWeb(Group groupWeb) {
		this.groupWeb = groupWeb;
	}

	public Scene getSceneWeb() {
		return sceneWeb;
	}

	public void setSceneWeb(Scene sceneWeb) {
		this.sceneWeb = sceneWeb;
	}

	public TextField getTextField_webSearch() {
		return textField_webSearch;
	}

	public VBox getVbox_Profile() {
		return vbox_Profile;
	}

	public Label getLabel_Profile() {
		return label_Profile;
	}

	public HBox getProfile_ToolBar() {
		return profile_ToolBar;
	}

	public Button getButton_AllRecipes_inProfile() {
		return button_AllRecipes_inProfile;
	}

	public Button getButtonFavoriets_inProfile() {
		return buttonFavoriets_inProfile;
	}

	public Button getButtonWeb_inProfile() {
		return buttonWeb_inProfile;
	}

	public Button getButtonSearch_inProfile() {
		return buttonSearch_inProfile;
	}

	public Button getButtonInfo_inProfile() {
		return buttonInfo_inProfile;
	}

	public Group getGroupProfile() {
		return groupProfile;
	}

	public Scene getSceneProfile() {
		return sceneProfile;
	}

	public void setTextField_webSearch(TextField textField_webSearch) {
		this.textField_webSearch = textField_webSearch;
	}

	public void setVbox_Profile(VBox vbox_Profile) {
		this.vbox_Profile = vbox_Profile;
	}

	public void setLabel_Profile(Label label_Profile) {
		this.label_Profile = label_Profile;
	}

	public void setProfile_ToolBar(HBox profile_ToolBar) {
		this.profile_ToolBar = profile_ToolBar;
	}

	public void setButton_AllRecipes_inProfile(Button button_AllRecipes_inProfile) {
		this.button_AllRecipes_inProfile = button_AllRecipes_inProfile;
	}

	public void setButtonFavoriets_inProfile(Button buttonFavoriets_inProfile) {
		this.buttonFavoriets_inProfile = buttonFavoriets_inProfile;
	}

	public void setButtonWeb_inProfile(Button buttonWeb_inProfile) {
		this.buttonWeb_inProfile = buttonWeb_inProfile;
	}

	public void setButtonSearch_inProfile(Button buttonSearch_inProfile) {
		this.buttonSearch_inProfile = buttonSearch_inProfile;
	}

	public void setButtonInfo_inProfile(Button buttonInfo_inProfile) {
		this.buttonInfo_inProfile = buttonInfo_inProfile;
	}

	public void setGroupProfile(Group groupProfile) {
		this.groupProfile = groupProfile;
	}

	public void setSceneProfile(Scene sceneProfile) {
		this.sceneProfile = sceneProfile;
	}

	public Button getButton_addRecipeRegular() {
		return button_addRecipeRegular;
	}

	public StackPane getStackPane_addRecipeRegular() {
		return stackPane_addRecipeRegular;
	}

	public Button getButton_addlinkRecipe() {
		return button_addlinkRecipe;
	}

	public HBox getHbox_SearchField_Web() {
		return Hbox_SearchField_Web;
	}

	public Button getButton_SearchFromWebAddress() {
		return button_SearchFromWebAddress;
	}

	public WebView getWebView_SearchRecipe() {
		return webView_SearchRecipe;
	}

	public WebEngine getWebEngin_SearchRecipe() {
		return webEngin_SearchRecipe;
	}

	public void setButton_addRecipeRegular(Button button_addRecipeRegular) {
		this.button_addRecipeRegular = button_addRecipeRegular;
	}

	public void setStackPane_addRecipeRegular(StackPane stackPane_addRecipeRegular) {
		this.stackPane_addRecipeRegular = stackPane_addRecipeRegular;
	}

	public void setHbox_SearchField_Web(HBox hbox_SearchField_Web) {
		Hbox_SearchField_Web = hbox_SearchField_Web;
	}

	public void setButton_SearchFromWebAddress(Button button_SearchFromWebAddress) {
		this.button_SearchFromWebAddress = button_SearchFromWebAddress;
	}

	public void setWebView_SearchRecipe(WebView webView_SearchRecipe) {
		this.webView_SearchRecipe = webView_SearchRecipe;
	}

	public void setWebEngin_SearchRecipe(WebEngine webEngin_SearchRecipe) {
		this.webEngin_SearchRecipe = webEngin_SearchRecipe;
	}

	public Scene getSceneAddRegularRecipe() {
		return sceneAddRegularRecipe;
	}

	public void setSceneAddRegularRecipe(Scene sceneAddRegularRecipe) {
		this.sceneAddRegularRecipe = sceneAddRegularRecipe;
	}

	public Button getButton_BackFromAddRecipeRegular() {
		return button_BackFromAddRecipeRegular;
	}

	public void setButton_BackFromAddRecipeRegular(Button button_BackFromAddRecipeRegular) {
		this.button_BackFromAddRecipeRegular = button_BackFromAddRecipeRegular;
	}

	public Button getButton_uploadPhotoAddRecipeRegular() {
		return button_uploadPhotoAddRecipeRegular;
	}

	public void setButton_uploadPhotoAddRecipeRegular(Button button_uploadPhotoAddRecipeRegular) {
		this.button_uploadPhotoAddRecipeRegular = button_uploadPhotoAddRecipeRegular;
	}

	public ImageView getImagwView_addNewRecipeRegular() {
		return imagwView_addNewRecipeRegular;
	}

	public void setImagwView_addNewRecipeRegular(ImageView imagwView_addNewRecipeRegular) {
		this.imagwView_addNewRecipeRegular = imagwView_addNewRecipeRegular;
	}

	public Button getButton_initProgram() {
		return Button_initProgram;
	}

	public void setButton_initProgram(Button button_initProgram) {
		Button_initProgram = button_initProgram;
	}

	public Scene getSceneInitProgram() {
		return SceneInitProgram;
	}

	public void setSceneInitProgram(Scene sceneInitProgram) {
		SceneInitProgram = sceneInitProgram;
	}

	public TextField getTextField_web_name() {
		return textField_web_name;
	}

	public HBox gethBox_format_table_AllRecipes() {
		return hBox_format_table_AllRecipes;
	}

	public VBox getVBOX_ViewRergularRecipe() {
		return VBOX_ViewRergularRecipe;
	}

	public Label getLabel_RecipeName_AllRecipes() {
		return label_RecipeName_AllRecipes;
	}

	public Region getLabel_Ingredients_AllRecipes() {
		return label_Ingredients_AllRecipes;
	}

	public Label getLabel_Steps_AllRecipes() {
		return label_Steps_AllRecipes;
	}

	public TextArea getTextArea_ingredients_allRecipes() {
		return textArea_ingredients_allRecipes;
	}

	public TextArea getTextArea_Steps_allRecipes() {
		return textArea_Steps_allRecipes;
	}

	public HBox getFavoriets_Formating() {
		return favoriets_Formating;
	}

	public VBox getVBOX_ViewRergularRecipe_favorite() {
		return VBOX_ViewRergularRecipe_favorite;
	}

	public Label getLabel_RecipeName_favorite() {
		return label_RecipeName_favorite;
	}

	public Label getLabel_Ingredients_favorite() {
		return label_Ingredients_favorite;
	}

	public TextArea getTextArea_ingredients_favorite() {
		return textArea_ingredients_favorite;
	}

	public Label getLabel_Steps_favorite() {
		return label_Steps_favorite;
	}

	public TextArea getTextArea_Steps_favorite() {
		return textArea_Steps_favorite;
	}

	public Group getGroupAddRegularRecipe() {
		return groupAddRegularRecipe;
	}

	public VBox getVbox_AddRegularRecipe() {
		return vbox_AddRegularRecipe;
	}

	public Label getLabel_AddRegularRecipe() {
		return label_AddRegularRecipe;
	}

	public HBox getHbox_label_addRegularRecipe() {
		return hbox_label_addRegularRecipe;
	}

	public HBox getHbox_FormatAddRegularrecipe() {
		return hbox_FormatAddRegularrecipe;
	}

	public TextField getTextField_newRecipeName() {
		return textField_newRecipeName;
	}

	public VBox getVbox_1THrds() {
		return Vbox_1THrds;
	}

	public VBox getVbox_2THrds() {
		return Vbox_2THrds;
	}

	public VBox getVbox_3THrds() {
		return Vbox_3THrds;
	}

	public Group getGroupInitProgram() {
		return groupInitProgram;
	}

	public void setTextField_web_name(TextField textField_web_name) {
		this.textField_web_name = textField_web_name;
	}

	public void sethBox_format_table_AllRecipes(HBox hBox_format_table_AllRecipes) {
		this.hBox_format_table_AllRecipes = hBox_format_table_AllRecipes;
	}

	public void setVBOX_ViewRergularRecipe(VBox vBOX_ViewRergularRecipe) {
		VBOX_ViewRergularRecipe = vBOX_ViewRergularRecipe;
	}

	public void setLabel_RecipeName_AllRecipes(Label label_RecipeName_AllRecipes) {
		this.label_RecipeName_AllRecipes = label_RecipeName_AllRecipes;
	}

	public void setLabel_Ingredients_AllRecipes(Region label_Ingredients_AllRecipes) {
		this.label_Ingredients_AllRecipes = label_Ingredients_AllRecipes;
	}

	public void setLabel_Steps_AllRecipes(Label label_Steps_AllRecipes) {
		this.label_Steps_AllRecipes = label_Steps_AllRecipes;
	}

	public void setTextArea_ingredients_allRecipes(TextArea textArea_ingredients_allRecipes) {
		this.textArea_ingredients_allRecipes = textArea_ingredients_allRecipes;
	}

	public void setTextArea_Steps_allRecipes(TextArea textArea_Steps_allRecipes) {
		this.textArea_Steps_allRecipes = textArea_Steps_allRecipes;
	}

	public void setFavoriets_Formating(HBox favoriets_Formating) {
		this.favoriets_Formating = favoriets_Formating;
	}

	public void setVBOX_ViewRergularRecipe_favorite(VBox vBOX_ViewRergularRecipe_favorite) {
		VBOX_ViewRergularRecipe_favorite = vBOX_ViewRergularRecipe_favorite;
	}

	public void setLabel_RecipeName_favorite(Label label_RecipeName_favorite) {
		this.label_RecipeName_favorite = label_RecipeName_favorite;
	}

	public void setLabel_Ingredients_favorite(Label label_Ingredients_favorite) {
		this.label_Ingredients_favorite = label_Ingredients_favorite;
	}

	public void setTextArea_ingredients_favorite(TextArea textArea_ingredients_favorite) {
		this.textArea_ingredients_favorite = textArea_ingredients_favorite;
	}

	public void setLabel_Steps_favorite(Label label_Steps_favorite) {
		this.label_Steps_favorite = label_Steps_favorite;
	}

	public void setTextArea_Steps_favorite(TextArea textArea_Steps_favorite) {
		this.textArea_Steps_favorite = textArea_Steps_favorite;
	}

	public void setGroupAddRegularRecipe(Group groupAddRegularRecipe) {
		this.groupAddRegularRecipe = groupAddRegularRecipe;
	}

	public void setVbox_AddRegularRecipe(VBox vbox_AddRegularRecipe) {
		this.vbox_AddRegularRecipe = vbox_AddRegularRecipe;
	}

	public void setLabel_AddRegularRecipe(Label label_AddRegularRecipe) {
		this.label_AddRegularRecipe = label_AddRegularRecipe;
	}

	public void setHbox_label_addRegularRecipe(HBox hbox_label_addRegularRecipe) {
		this.hbox_label_addRegularRecipe = hbox_label_addRegularRecipe;
	}

	public void setHbox_FormatAddRegularrecipe(HBox hbox_FormatAddRegularrecipe) {
		this.hbox_FormatAddRegularrecipe = hbox_FormatAddRegularrecipe;
	}

	public void setTextField_newRecipeName(TextField textField_newRecipeName) {
		this.textField_newRecipeName = textField_newRecipeName;
	}

	public void setVbox_1THrds(VBox vbox_1tHrds) {
		Vbox_1THrds = vbox_1tHrds;
	}

	public void setVbox_2THrds(VBox vbox_2tHrds) {
		Vbox_2THrds = vbox_2tHrds;
	}

	public void setVbox_3THrds(VBox vbox_3tHrds) {
		Vbox_3THrds = vbox_3tHrds;
	}

	public void setGroupInitProgram(Group groupInitProgram) {
		this.groupInitProgram = groupInitProgram;
	}

	public Button getButton_AddIng() {
		return button_AddIng;
	}

	public Button getButton_Search() {
		return button_Search;
	}

	public void addNewButtonEVENT(EventHandler<ActionEvent> event, Button button) {
		button.setOnAction(event);
	}

	public CheckBox getCheckBox_sceneAll() {
		return checkBox_sceneAll;
	}

	public void addNewCheckEVENT(EventHandler<ActionEvent> event, CheckBox checkBox) {
		checkBox.setOnAction(event);
	}

	public WebEngine getFavoritesWebEngin() {
		return favoritesWebEngin;
	}

	public String[] getIntTypeArray() {
		return intTypeArray;
	}

	public String deleteRecipe() {
		String recipe = allRecipesListView.getSelectionModel().getSelectedItem();

		allRecipesListView.getItems().remove(allRecipesListView.getSelectionModel().getSelectedIndex());

		return recipe;
	}

	public void setButton_Update(Button button_Update) {
		this.button_Update = button_Update;
	}

	public Button getButton_backFromUpdate() {
		return button_backFromUpdate;
	}

	public Scene getSceneUpdateRecipe() {
		return sceneUpdateRecipe;
	}

	public ComboBox<String> getComboBox_ingType() {
		return comboBox_ingType;
	}

	public String setUpdateScene() {

		String recipe = allRecipesListView.getSelectionModel().getSelectedItem();
		Label_nameUpdate.setText(recipe);
		return recipe;

	}

	public Button getButton_saveFromUpdate() {
		return button_saveFromUpdate;
	}

	public void update_TablesUpdate(Recipe recipe) {
		tableView_StepsUpdate.getItems().addAll(((RecipeRegular) recipe).getSteps());
		tableView_updateIngred.getItems().addAll(((RecipeRegular) recipe).getIngredients());
	}

	public TableView<Ingredient> getTableView_updateIngred() {
		return tableView_updateIngred;
	}

	public TableView<Step> getTableView_StepsUpdate() {
		return tableView_StepsUpdate;
	}

	public RecipeRegular updateRecipeRegular() {
		String name;
		if (textField_nameUpdate.getText() == "") {
			name = Label_nameUpdate.getText();
		} else {
			name = textField_nameUpdate.getText();
		}

		RecipeRegular recipeRegular = new RecipeRegular(name, tableView_updateIngred.getItems(),
				tableView_StepsUpdate.getItems(), null);
		return recipeRegular;
	}

	public TextField getTextField_nameUpdate() {
		return textField_nameUpdate;
	}
}
