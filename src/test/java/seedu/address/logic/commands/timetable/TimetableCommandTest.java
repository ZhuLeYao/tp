package seedu.address.logic.commands.timetable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.person.ListCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.jobs.sorters.SortbyTimeAndEarn;

import java.sql.Time;
import java.time.LocalDate;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalDeliveryJobs.getTypicalDeliveryJobSystem;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

public class TimetableCommandTest {
    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryJobSystem(), new UserPrefs());
        expectedModel = new ModelManager(getTypicalAddressBook(), getTypicalDeliveryJobSystem(), new UserPrefs());
    }

    @Test
    public void execute_focusDateIsUpdated() {
        expectedModel.updateFocusDate(LocalDate.now());
        expectedModel.updateSortedDeliveryJobList(TimetableCommand.SORTER);
        expectedModel.updateSortedDeliveryJobListByDate();
        expectedModel.updateWeekDeliveryJobList(LocalDate.now());
        assertCommandSuccess(new TimetableCommand(), model, TimetableCommand.SHOWING_TIMETABLE_MESSAGE, expectedModel);
    }
}
