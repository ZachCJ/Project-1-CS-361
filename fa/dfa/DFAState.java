package fa.dfa;

import java.util.Map;

import fa.State;

public class DFAState extends State {
    // to store transitions for this state
    Map<Character, DFAState> transitions;

    public DFAState(String name) {
        super(name);
    }

    // Add a transition for this state
    public void addTransition(char symbol, DFAState nextState) {
        transitions.put(symbol, nextState);
    }

    // Get the next state for a given input symbol
    public DFAState getNextState(char symbol) {
        return transitions.get(symbol);
    }

    // Get all transitions for this state
    public Map<Character, DFAState> getTransitions() {
        return transitions;
    }
}
