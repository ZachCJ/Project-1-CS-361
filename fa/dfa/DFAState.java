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

    // The following methods allow us to use contains() on a LinkedHashSet<> to
    // check if a State is in the set or not
    // Takes in and Object which is cast to DFAState then checks if its name matches
    // the current States name
    @Override
    public boolean equals(Object newState) {
        // Cast newState to be a DFAState
        DFAState other = (DFAState) newState;
        return this.getName().equals(other.getName());
    }

    // Allows us to compare based on name
    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    // TODO Add a toString()?
}
