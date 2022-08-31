package Controller;

import java.util.ArrayList;
import java.util.InputMismatchException;

import Exceptions.EmptyException;
import Exceptions.ExistsException;
import Exceptions.InValidInputException;
import Model.Model;
import Model.Recipe;
import Model.RecipeLink;
import Model.RecipeRegular;
import View.View_All;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;

public class Controller {

	public Controller(Model model, View_All view) {
		try {
			addNewRecipeLink(model, view);
			initStartWindow(model, view);
			allRecipe_Scenes(model, view);
			Favorites_Scenes(model, view);
			Search_Scenes(view, model);
			Web_Scenes(model, view);
			Profile_Scenes(model, view);
			webViewSearch(model, view);
			showRecipeInAllRecipe(model, view);
			initUpdateScene(model,view);
		} catch (UnsupportedOperationException e) {
			
		}			catch (Exception e2) {

		}
	}

	private void initUpdateScene(Model model, View_All view) {
		EventHandler<ActionEvent> button_BackFromUpdate = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneAll());
				view.setList(getList(model));
				view.getTableView_updateIngred().getItems().clear();
				view.getTableView_StepsUpdate().getItems().clear();
			}
			
		};
		view.addNewButtonEVENT(button_BackFromUpdate, view.getButton_backFromUpdate());
		
		
		EventHandler<ActionEvent> button_UpdatefromUpdate = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				String name = view.getLabel_nameUpdate().getText();
				RecipeRegular recipe = view.updateRecipeRegular();
				model.updateRecipeRegular(name, recipe);
				
				view.getTextField_nameUpdate().clear();
				view.getTableView_updateIngred().getItems().clear();
				view.getTableView_StepsUpdate().getItems().clear();
				view.setList(getList(model));
				view.setScene(view.getSceneAll());
			}
			
		};
		view.addNewButtonEVENT(button_UpdatefromUpdate, view.getButton_saveFromUpdate());
		
	}

	private void showRecipeInAllRecipe(Model model, View_All view) {

		view.getAllRecipesListView().getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<String>() {

					public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

						try {
							view.setRecipeView_ALL(getRecipeFromName(model, arg2));
						} catch (NullPointerException npe) {
						} catch (Exception e) {
						}

					}
				});

		EventHandler<ActionEvent> CheckBox_allRecieps = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				try {
					if (view.getCheckBox_sceneAll().isSelected()) {
						model.findRercipeByName(view.getLabel_RecipeName_AllRecipes().getText()).setFavorite(true);

					} else {
						model.findRercipeByName(view.getLabel_RecipeName_AllRecipes().getText()).setFavorite(false);

					}
				} catch (NullPointerException npe) {
				} catch (Exception ex) {
				}

			}
		};
		view.addNewCheckEVENT(CheckBox_allRecieps, view.getCheckBox_sceneAll());
		
		
		view.getFavoritesListView().getSelectionModel().selectedItemProperty()
		.addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

				try {
					view.setRecipeView_Favorite(getRecipeFromName(model, arg2));
				} catch (NullPointerException npe) {
				} catch (Exception e) {
				}

			}
		});
	}

	private void webViewSearch(Model model, View_All view) {

		EventHandler<ActionEvent> button_searchFromTextField_inProfile = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				

				view.loadPage();


			}
		};
		view.changeScene(button_searchFromTextField_inProfile, view.getButton_SearchFromWebAddress());

		AddNewRecipeRegular(model, view);
	}

	private void Profile_Scenes(Model model, View_All view) {

		EventHandler<ActionEvent> button_All_inProfile = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneAll());
				view.setList(getList(model));
			}
		};
		view.changeScene(button_All_inProfile, view.getButton_AllRecipes_inProfile());

		EventHandler<ActionEvent> button_Fav_inProfile = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneFavoriets());
				view.setListFavorite(model.getRecipes());
			}
		};
		view.changeScene(button_Fav_inProfile, view.getButtonFavoriets_inProfile());

		EventHandler<ActionEvent> button_Search_inProfile = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneSearch());
			}
		};
		view.changeScene(button_Search_inProfile, view.getButtonSearch_inProfile());

		EventHandler<ActionEvent> button_Web_inProfile = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneWeb());
			}
		};
		view.changeScene(button_Web_inProfile, view.getButtonWeb_inProfile());
	}

	private void Web_Scenes(Model model, View_All view) {
		/////////////////////////////////////////////////////////
		// info: change from Web

		/////////////////////////////////////////////////////////

		EventHandler<ActionEvent> button_All_inWeb = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneAll());
				view.setList(getList(model));
			}
		};
		view.changeScene(button_All_inWeb, view.getButton_AllRecipes_inWeb());

		EventHandler<ActionEvent> button_Fav_inWeb = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneFavoriets());
				view.setListFavorite(model.getRecipes());
			}
		};
		view.changeScene(button_Fav_inWeb, view.getButtonFavoriets_inWeb());

		EventHandler<ActionEvent> button_Search_inWeb = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneSearch());
			}
		};
		view.changeScene(button_Search_inWeb, view.getButtonSearch_inWeb());

		EventHandler<ActionEvent> button_Profile_inWeb = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneProfile());
			}
		};
		view.changeScene(button_Profile_inWeb, view.getButtonInfo_inWeb());
	}

	private void Search_Scenes(View_All view, Model model) {
		/////////////////////////////////////////////////////////
		// info: change from Search

		/////////////////////////////////////////////////////////
		EventHandler<ActionEvent> button_all_inSearch = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneAll());
				view.setList(getList(model));

			}
		};
		view.changeScene(button_all_inSearch, view.getButton_AllRecipes_inSearch());

		EventHandler<ActionEvent> button_Fav_inSearch = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneFavoriets());
				view.setListFavorite(model.getRecipes());
			}
		};
		view.changeScene(button_Fav_inSearch, view.getButtonFavoriets_inSearch());

		EventHandler<ActionEvent> button_web_inSearch = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneWeb());
			}
		};
		view.changeScene(button_web_inSearch, view.getButtonWeb_inSearch());

		EventHandler<ActionEvent> button_Profile_inSearch = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneProfile());
			}
		};
		view.changeScene(button_Profile_inSearch, view.getButtonInfo_inSearch());

		EventHandler<ActionEvent> button_searchList = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				try {
					view.search(model.getRecipes());
				} catch (EmptyException e) {
					view.initAlert("Please Enter Value", AlertType.ERROR);
				} catch (Exception e) {
					view.initAlert("Something want wrong", AlertType.ERROR);
				}
			}
		};
		view.addNewButtonEVENT(button_searchList, view.getButton_Search());
	}

	private void Favorites_Scenes(Model model, View_All view) {
		/////////////////////////////////////////////////////////
		// info: change from fav

		/////////////////////////////////////////////////////////
		EventHandler<ActionEvent> button_All_inFav = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneAll());
				view.setList(getList(model));
				view.getFavoritesListView().getItems().clear();
			}
		};
		view.changeScene(button_All_inFav, view.getButton_AllRecipes_inFav());

		EventHandler<ActionEvent> button_search_inFav = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneSearch());
				view.getFavoritesListView().getItems().clear();
			}
		};
		view.changeScene(button_search_inFav, view.getButtonSearch_inFav());

		EventHandler<ActionEvent> button_web_inFav = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneWeb());
				view.getFavoritesListView().getItems().clear();
			}
		};
		view.changeScene(button_web_inFav, view.getButtonWeb_inFav());

		EventHandler<ActionEvent> button_Profile_inFav = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneProfile());
				view.getFavoritesListView().getItems().clear();
			}
		};
		view.changeScene(button_Profile_inFav, view.getButtonInfo_inFav());
		
		
		
		
		
		
	}

	private void allRecipe_Scenes(Model model, View_All view) {

		EventHandler<ActionEvent> button_favorites_inAll = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneFavoriets());
				view.setListFavorite(model.getRecipes());
				view.getAllRecipesListView().getItems().clear();

			}
		};
		view.changeScene(button_favorites_inAll, view.getButtonFavoriets_inAll());

		EventHandler<ActionEvent> button_search_inAll = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneSearch());
				view.getAllRecipesListView().getItems().clear();

			}
		};
		view.changeScene(button_search_inAll, view.getButtonSearch_inAll());

		EventHandler<ActionEvent> button_web_inAll = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneWeb());
				view.getAllRecipesListView().getItems().clear();
			}
		};
		view.changeScene(button_web_inAll, view.getButtonWeb_inAll());

		EventHandler<ActionEvent> button_Profile_inAll = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneProfile());
				view.getAllRecipesListView().getItems().clear();

			}
		};
		view.changeScene(button_Profile_inAll, view.getButtonInfo_inAll());

		EventHandler<ActionEvent> button_AddRecipeRgular_inAll = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneAddRegularRecipe());
				view.getAllRecipesListView().getItems().clear();

			}
		};
		view.changeScene(button_AddRecipeRgular_inAll, view.getButton_addRecipeRegular());

		EventHandler<ActionEvent> button_BackToAll_inAddRecipeRgular = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneAll());
				view.setList(getList(model));
			}
		};
		view.changeScene(button_BackToAll_inAddRecipeRgular, view.getButton_BackFromAddRecipeRegular());
		
		
		EventHandler<ActionEvent> Button_delete = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				try {
					model.deleteRecipe(getRecipeFromName(model, view.deleteRecipe()));
				} catch (IndexOutOfBoundsException e) {
					view.initAlert("You did not choose any Recipe", AlertType.WARNING);
				}
			}
			
		};
		view.addNewButtonEVENT(Button_delete, view.getButton_delete());
		
		EventHandler<ActionEvent> Button_Edit = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Recipe recipe = getRecipeFromName(model, view.setUpdateScene());
				
				if (view.setUpdateScene() != null) {
					view.update_TablesUpdate(recipe);
					view.setScene(view.getSceneUpdateRecipe());
					view.getAllRecipesListView().getItems().clear();
				}else {
					view.initAlert("you didn't choose any recipe",AlertType.WARNING);
				}
			}
			
		};
		view.changeScene(Button_Edit, view.getButton_Update());
		
	}

	private void initStartWindow(Model model, View_All view) {

		EventHandler<ActionEvent> button_initProgram = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene(view.getSceneAll());
				view.setList(getList(model));
			}
		};
		view.changeScene(button_initProgram, view.getButton_initProgram());
	}

	private void addNewRecipeLink(Model model, View_All view) {
		/////////////////////////////////////////////////////////
		// info: add new recipe WEB

		/////////////////////////////////////////////////////////
		EventHandler<ActionEvent> button_addNewRecipeLink = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				RecipeLink recipeLink;
				try {
					recipeLink = view.addNewRecipeLink();
					model.createNewLinkRecipe(recipeLink.getRecipeName(), recipeLink.getLink());
				} catch (EmptyException e) {
					view.initAlert("Please Enter Value", AlertType.ERROR);
				}catch (NullPointerException e) {
					view.initAlert("Something want wrong", AlertType.ERROR);
				} catch (Exception e) {
					view.initAlert("Something want wrong", AlertType.ERROR);
				}
			}
		};
		view.addNewRecipeLinkEVENT(button_addNewRecipeLink, view.getButton_addlinkRecipe());
	}

	private void AddNewRecipeRegular(Model model, View_All view) {
		/////////////////////////////////////////////////////////
		// info: Add new recipe regular
		/////////////////////////////////////////////////////////
		EventHandler<ActionEvent> button_addnewING = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				
				try {
					view.addIngred();
				} catch (EmptyException e) {
					view.initAlert("Please Enter Value", AlertType.ERROR);
				} catch (InValidInputException e) {
					view.initAlert("Please Enter positive Value", AlertType.ERROR);
				} catch (InputMismatchException e) {
					view.initAlert("Unsupportted Type", AlertType.ERROR);
				} catch (NumberFormatException e) {
					view.initAlert("Unsupportted Type", AlertType.ERROR);
				} catch (NullPointerException e) {
					view.initAlert("Something want wrong", AlertType.ERROR);
				}catch (ExistsException e) {
					view.initAlert("Ingredient already exist", AlertType.ERROR);
				} catch (Exception e) {
					view.initAlert("Something want wrong", AlertType.ERROR);
				}
				
			}
		};
		view.addNewIngEVENT(button_addnewING, view.getButton_AddIng());

		EventHandler<ActionEvent> button_addnewStep = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				try {
					view.addStep();
				} catch (EmptyException e) {
					view.initAlert("Please Enter Value", AlertType.ERROR);
				} catch (InValidInputException e) {
					view.initAlert("Please Enter positive Value", AlertType.ERROR);
				}catch (ExistsException e) {
					view.initAlert("Step already exist", AlertType.ERROR);
				} catch (Exception e) {
					view.initAlert("Something want wrong", AlertType.ERROR);
				}
			}
		};
		view.addNewStepEVENT(button_addnewStep, view.getButton_AddStep());

		EventHandler<ActionEvent> button_addnewImamge_to_newRecipeRegular = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setImage(arg0, view.getImagwView_addNewRecipeRegular());
			}
		};
		view.changeScene(button_addnewImamge_to_newRecipeRegular, view.getButton_uploadPhotoAddRecipeRegular());

		EventHandler<ActionEvent> button_addNewRecipeRegular = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				RecipeRegular rp = null;
				try {
					rp = view.addNewRegularRecipe(model.getRecipes());
					model.createNewRegularRecipe(rp.getRecipeName(), rp.getIngredients(), rp.getSteps(),rp.getImage(),view.getIntTypeArray());
				} catch (EmptyException e) {
					view.initAlert("Please Enter Value", AlertType.ERROR);
				}catch (NullPointerException e) {
					view.initAlert("Something want wrong", AlertType.ERROR);
				}catch (ExistsException e) {
					view.initAlert("Recipe name already exists", AlertType.ERROR);
				} catch (Exception e) {
					view.initAlert("Something want wrong", AlertType.ERROR);
				}
				view.setScene(view.getSceneAll());
				view.setList(getList(model));
			}
		};
		view.addNewRegularRecipeEVENT(button_addNewRecipeRegular, view.getButton_addNewRecipeRegular());
	}

	public Recipe getRecipeFromName(Model m, String name) {
		for (Recipe recipe : m.getRecipes()) {
			if (recipe.getRecipeName().equals(name)) {
				return recipe;
			}
		}
		return null;
	}

	public ArrayList<Recipe> getList(Model m) {
		return m.getRecipes();
	}
}
