package fa.dfa;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface {
    // * Instance Variables

    // Store all characters that make up the Alphabet
    Set<Character> sigma;
    // Store All DFA States
    Set<DFAState> Q;

    DFAState startState;
    DFAState finalState;

    // Stores the transition table => δ
    Map<DFAState, Map<Character, DFAState>> transitions;

    // * Constructor
    public DFA() {
        this.sigma = new LinkedHashSet<>();

    }

    @Override
    public boolean addState(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addState'");
    }

    @Override
    public boolean setFinal(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFinal'");
    }

    @Override
    public boolean setStart(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStart'");
    }

    @Override
    public void addSigma(char symbol) {
        // Adding symbol to sigma set
        sigma.add(symbol);
    }

    @Override
    public boolean accepts(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accepts'");
    }

    @Override
    public Set<Character> getSigma() {
        return sigma;
    }

    @Override
    public State getState(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getState'");
    }

    @Override
    public boolean isFinal(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFinal'");
    }

    @Override
    public boolean isStart(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isStart'");
    }

    @Override
    public boolean addTransition(String fromState, String toState, char onSymb) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTransition'");
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

    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder("");
        String currentSigma = sigmaString();
        retString.append("Sigma = " + currentSigma);
        return retString.toString();
    }

}
