package fa.dfa;

import java.util.LinkedHashSet;
import java.util.Hashtable;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {
    // * Instance Variables

    // Store all characters that make up the Alphabet
    Set<Character> sigma;
    // Store All DFA States
    Set<DFAState> allStates;

    DFAState startState;
    DFAState finalState;

    // Stores the transition table => δ
    Hashtable<Hashtable<DFAState, Character>, DFAState> transitions;

    // * Constructor
    public DFA() {
        this.allStates = new LinkedHashSet<>();
        this.sigma = new LinkedHashSet<>();
        this.transitions = new Hashtable<>();
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
        if(allStates.contains(newFinal)){
            allStates.remove(newFinal);
            finalState = newFinal;
            allStates.add(finalState);
            return true;
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
        return finalState.equals(currentState);
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
        if(finalState == null) {
            return false; //Final state doesn't yet exist
        }
        return finalState.getName().equals(name);

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
        Hashtable<DFAState, Character> path = new Hashtable<>(1);
        path.put(DFAFromState, onSymb);
        if(!(allStates.contains(DFAFromState) && allStates.contains(DFAToState) && sigma.contains(onSymb)) || transitions.containsKey(path)){
            return false; //A state or symbol does not exist, or transition would violate DFA parameters
        }
        //Map<Map<fromState, onSymb>, toState>
        transitions.put(path, DFAToState);
        return true;
    }

    @Override
    public DFA swap(char symb1, char symb2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swap'");
    }

    /**
     * Iterates over the elements currently in sigma builds a string
     * 
     * @return String representation of the sigma
     */
    private String sigmaString() {
        String sigmaString = "{ ";
        Set<Character> currentSigma = getSigma();

        for (Character character : currentSigma) {
            sigmaString += character;
            sigmaString += " ";
        }
        sigmaString += "}";
        return sigmaString;
    }

    /**
     * Iterates over the elements currently in allStates builds a string
     * 
     * @return String representation of the allStates
     */
    public String allStatesString() {
        String sigmaString = "{ ";
        Set<DFAState> currentallStates = this.allStates;

        for (DFAState DFAState : currentallStates) {
            sigmaString += DFAState;
            sigmaString += " ";
        }
        sigmaString += "}";
        return sigmaString;
    }

    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder("");
        String currentSigma = sigmaString();
        retString.append("Sigma = " + currentSigma);
        return retString.toString();
    }

}
