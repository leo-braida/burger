package com.burger;

import java.util.Stack;

public class CashierInvoker {
    private Stack<Command> commandHistory = new Stack<>();
    public void executeCommand(Command c) { c.execute(); commandHistory.push(c); }
    public void undoCommand() { if (!commandHistory.isEmpty()) commandHistory.pop().undo(); }
}
