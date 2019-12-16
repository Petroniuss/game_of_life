package agh.iet.devs.view.menu;

import agh.iet.devs.config.SimulationState;
import agh.iet.devs.view.controller.ViewConfiguration;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StatisticsMenu extends VBox {

    private final SimulationState state;

    private final Label dayLabel;
    private final Label animalLabel;
    private final Label foodLabel;
    private final Label averageEnergyLabel;
    private final Label lifeExpectancyLabel;
    private final Label dominatingGenomeLabel;
    private final Label avgChildrenLabel;

    public StatisticsMenu(SimulationState state) {
        this.state = state;

        this.dayLabel = new Label("Day: " + state.dayCount.get());
        this.animalLabel = new Label("Animals: " + state.animalCount.get());
        this.foodLabel = new Label("Food: " + state.foodCount.get());
        this.averageEnergyLabel = new Label(String.format("Average Energy: %.2f", state.averageEnergy));
        this.lifeExpectancyLabel = new Label(String.format("Life Expectancy: %.2f", state.lifeExpectancy));
        this.dominatingGenomeLabel = new Label("Dominating Genome: ");
        this.avgChildrenLabel = new Label(String.format("Average Number of Children: %.2f", state.averageChildren));

        this.dominatingGenomeLabel.textOverrunProperty().setValue(OverrunStyle.CENTER_ELLIPSIS);

        final var label = new Text("Statistics");
        label.setFont(Font.font(24));
        label.setFill(Color.WHITE);
        final var labelBox = new HBox(label);

        labelBox.setPrefWidth(ViewConfiguration.SIDE_MENU_WIDTH);
        labelBox.setAlignment(Pos.BASELINE_CENTER);

        getChildren().addAll(
                labelBox,
                dayLabel,
                animalLabel,
                foodLabel,
                averageEnergyLabel,
                lifeExpectancyLabel,
                dominatingGenomeLabel,
                avgChildrenLabel
        );

        setPadding(new Insets(10, 25, 25, 10));
    }

    public void onUpdate() {
        this.dayLabel.setText("Day: " + state.dayCount.get());
        this.animalLabel.setText("Animals: " + state.animalCount.get());
        this.foodLabel.setText("Food: " + state.foodCount.get());
        this.averageEnergyLabel.setText(String.format("Average Energy: %.2f", state.averageEnergy));
        this.lifeExpectancyLabel.setText(String.format("Life Expectancy: %.2f", state.lifeExpectancy));
        this.dominatingGenomeLabel.setText("Dominating Genome: \n" + state.dominatingGenome.toString().replace(", ", ""));
        this.avgChildrenLabel.setText(String.format("Average Number of Children: %.2f", state.averageChildren));
    }

}
