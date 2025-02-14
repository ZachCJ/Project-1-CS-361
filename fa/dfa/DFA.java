package fa.dfa;

import java.util.LinkedHashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.function.BiConsumer;

import fa.State;

public class DFA implements DFAInterface {
    // * Instance Variables

    // Store all characters that make up the Alphabet
    Set<Character> sigma;
    // Store All DFA States
    Set<DFAState> allStates;

    DFAState startState;
    Set<DFAState> finalStates;

    // Stores the transitions in a way that can be navigated in memory
    Hashtable<Hashtable<DFAState, Character>, DFAState> transitions;

    // * Constructor
    public DFA() {
        this.allStates = new LinkedHashSet<>();
        this.sigma = new LinkedHashSet<>();
        this.transitions = new Hashtable<>();
        this.finalStates = new LinkedHashSet<>();
    }

    @Override
    public boolean addState(String name) {
        DFAState newState = new DFAState(name);
        if (allStates.contains(newState)) {
            return false; // State already exists
        }
        // Add the new state to the set
        return allStates.add(newState);
    }

    @Override
    public boolean setFinal(String name) {
        DFAState newFinal = new DFAState(name);
        if(allStates.contains(newFinal) && !finalStates.contains(newFinal)){
            return finalStates.add(newFinal);
        }
        return false; //Final State is not in set
    }

    @Override
    public boolean setStart(String name) {
        DFAState newStart = (DFAState) getState(name);
        if (newStart == null) {
            return false;
        }
        // State was found and Set to be start state
        startState = newStart;
        return true;
    }

    @Override
    public void addSigma(char symbol) {
        if(sigma.contains(symbol)) {
            return; //Prevents Duplicate Symbols
        }
        // Adding symbol to sigma set
        sigma.add(symbol);
    }

    @Override
    public boolean accepts(String s) {
        char[] symbols = s.toCharArray();
        DFAState currentState = startState;
        for(int i = 0; i < s.length(); i++){
            Hashtable<DFAState, Character> attemptingPath = new Hashtable<>(1);
            attemptingPath.put(currentState, symbols[i]);
            if(transitions.containsKey(attemptingPath)){
                currentState = transitions.get(attemptingPath);
            } else {
                return false;
            }
        }
        return finalStates.contains(currentState);
    }

    @Override
    public Set<Character> getSigma() {
        return sigma;
    }

    @Override
    public State getState(String name) {
        // Iterate through all states and finds the one with a matching name
        for (DFAState dfaState : allStates) {
            System.out.println(dfaState.getName());
            if (dfaState.getName().equals(name)) {
                return dfaState;
            }
        }
        // Null if no match was found
        return null;
    }

    @Override
    public boolean isFinal(String name) {
        if(finalStates.isEmpty()) {
            return false; //Final state doesn't yet exist
        }
        DFAState targetState = new DFAState(name);
        return finalStates.contains(targetState);

    }

    @Override
    public boolean isStart(String name) {
        if(startState == null) {
            return false; //Start state doesn't yet exist
        }
        return startState.getName().equals(name);
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        DFAState DFAFromState = new DFAState(fromState);
        DFAState DFAToState = new DFAState(toState);
        for(DFAState state : allStates) {
            if(state.getName().equals(fromState)){
                DFAFromState = state;
                break;
            }
        }
        if(!(allStates.contains(DFAFromState) && allStates.contains(DFAToState) && sigma.contains(onSymb))) {
            return false; //A state or symbol does not exist, or transition would violate DFA parameters
        }
        //Updating state
        allStates.remove(DFAFromState);
        DFAFromState.addTransition(onSymb,DFAToState);
        allStates.add(DFAFromState);
        //Updating transition map
        Hashtable<DFAState, Character> path = new Hashtable<>(1);
        path.put(DFAFromState, onSymb);
        //Map<Map<fromState, onSymb>, toState>
        transitions.put(path, DFAToState);
        return true;
    }

    @Override
    public DFA swap(char symb1, char symb2) {
        DFA newDFA = new DFA();
        for(Character newSigma : sigma) {
            newDFA.addSigma(newSigma);
        }
        for(DFAState newState : allStates) {
            newDFA.addState(newState.getName());
        }
        newDFA.setStart(startState.getName());
        for(DFAState newState: finalStates) {
            newDFA.setFinal(newState.getName());
        }
        //The accept method is what is performed on all elements of the transitions hashtable.
        BiConsumer<Hashtable<DFAState, Character>, DFAState> execute = new BiConsumer<Hashtable<DFAState, Character>, DFAState>() {
            @Override
            public void accept(Hashtable hashtable, DFAState dfaState) {
                DFAState state = (DFAState) hashtable.keys().nextElement(); //This hashtable should only have one element for keys
                if (hashtable.containsValue(symb1)) {
                    newDFA.addTransition(state.getName(),  dfaState.getName(), symb2);
                } else if (hashtable.containsValue(symb2)) {
                    newDFA.addTransition(state.getName(),  dfaState.getName(), symb1);
                } else {
                    Character symbol = (Character) hashtable.elements().nextElement(); //This hashtable should only have one element for values
                    newDFA.addTransition(state.getName(), dfaState.getName(), symbol);
                }
            }
        };
        transitions.forEach(execute);
        return newDFA;
    }

    /**
     * Iterates over the elements currently in sigma builds a string
     * 
     * @return String representation of the sigma
     */
    private String sigmaString() {
        String sigmaString = "";
        Set<Character> currentSigma = getSigma();

        for (Character character : currentSigma) {
            sigmaString += character;
            sigmaString += " ";
        }
        return sigmaString.substring(0, sigmaString.length() - 1);
    }

    /**
     * Iterates over the elements currently in allStates builds a string
     * 
     * @return String representation of the allStates
     */
    public String allStatesString() {
        String sigmaString = "{";
        for (DFAState state : allStates) {
            sigmaString = sigmaString.concat(state.toString() + " ");
        }
        sigmaString = sigmaString.substring(0, sigmaString.length() - 1).concat( "}\n");
        return sigmaString;
    }

    /**
     * Construct the textual representation of the DFA, for example
     * A simple two state DFA
     * Q = { a b }
     * Sigma = { 0 1 }
     * delta =
     *		0	1
     *	a	a	b
     *	b	a	b
     * q0 = a
     * F = { b }
     *
     * The order of the states and the alphabet is the order
     * in which they were instantiated in the DFA.
     * @return String representation of the DFA
     */
    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder("Q = ".concat(allStatesString()));
        String currentSigma = sigmaString();
        retString.append("Sigma = ".concat("{" + currentSigma + "}\n"));
        retString.append("delta = ".concat(deltaString()));
        retString.append("q0 = ".concat(startState.getName() + "\n"));
        retString.append("F = ".concat(finalStatesString() + "\n"));
        return retString.toString();
    }

    private String finalStatesString() {
        String str = "{";
        for(DFAState state : finalStates) {
            str = str.concat(state.toString() + " ");
        }
        str = str.substring(0, str.length() - 1).concat("}");
        return str;
    }

    private String deltaString() {
        String str = "\n";
        str = str.concat("   " + sigmaString() + "\n");
        for(DFAState state : allStates){
            str = str.concat(" " + state.toString() + " ");
            for(Character symbol: sigma){
                String name = state.getNextState(symbol).getName();
                if(name != null){
                    str = str.concat(state.getNextState(symbol).getName() + " ");
                } else {
                    str = str.concat(" _ ");
                }
            }
            str = str.concat("\n");
        }
        return str;
    }
}
