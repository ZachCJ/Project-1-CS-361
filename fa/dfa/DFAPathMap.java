package fa.dfa;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class DFAPathMap<Character, DFAState> implements Map<Character, DFAState> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public DFAState get(Object key) {
        return null;
    }

    @Override
    public DFAState put(Character key, DFAState value) {
        return null;
    }

    @Override
    public DFAState remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends Character, ? extends DFAState> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<Character> keySet() {
        return null;
    }

    @Override
    public Collection<DFAState> values() {
        return null;
    }

    @Override
    public Set<Entry<Character, DFAState>> entrySet() {
        return null;
    }
}
