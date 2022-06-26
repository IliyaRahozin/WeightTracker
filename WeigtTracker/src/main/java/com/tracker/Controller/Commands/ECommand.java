package com.tracker.Controller.Commands;

public enum ECommand {
    home(new Home()),
    login(new Login()),
    register(new Register()),
    commandLogin(new CommandLogin()),
    commandRegister(new CommandRegister()),
    commandProfile(new CommandProfile()),
    logOut(new CommandLogOut()),
    commandUpdateUser(new CommandUpdateUser()),
    usersList(new CommandUsersList()),
    deleteUser(new CommandDeleteUser()),
    foodList(new CommandFoodList()),
    addFood(new CommandAddFood()),
    deleteFood(new CommandDeleteFood()),
    track(new Track()),
    eatFood(new CommandEatFood())
    ;
    private final ICommand command;
    ECommand(ICommand command) {
        this.command = command;
    }
    public ICommand getCommand() { return command; }
}
