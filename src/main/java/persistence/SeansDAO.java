package persistence;

import domain.Seans;

public interface SeansDAO {
    void save (Seans seans);

    void delate (Seans seansId);
}
