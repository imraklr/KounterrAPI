package com.kounterr.kounterrapi.dao;

import java.math.BigInteger;

/**
 * @author Rakesh Kumar (<a href="https://github.com/imraklr">imraklr</a>)
 */
public interface CounterDAO {

    /**
     * Returns true if the session was added successfully to the table else false.
     * @implNote If this method returns false, it is the responsibiliy of the client to store 
     * the values locally before trying again.
     * @param articleId - Unique string representing the article in the tuple of the database
     * @param ticks - number of hits/counts
     * @return True if the session was added successfully to the table else false.
     */
    boolean addSession(String articleId, BigInteger ticks);

    /**
     * If step > 0 then the tick will be incremented by 1
     * else if step == 0 then the query will not be executed
     * else if tick-1 < 0 then the query will not be executed
     * else tick will be decremented by 1
     * @implNote This function causes an update operation in the tuple.
     * @param step - Step can be positive(Increment), negative(Decrement) or zero(NoOp).
     * @param articleId - Unique string representing the article in the tuple of the database
     */
    void updateTick(byte step, String articleId);

    /**
     * Returns the number of ticks or the count of hits.
     * @param articleId - Unique string representing the article in the tuple of the database
     * @return Number of counts or hits associated with a specific Article ID
     */
    BigInteger getTicksCount(String articleId);
    
    /**
     * Removes the article(tuple) associated with the articleId provided in the method parameter articleId.
     * @param articleId - Unique string representing the article in the tuple of the database
     */
    void removeArticle(String articleId);

    /**
     * Returns the ID from the current Article ID
     * @param articleId - Unique string representing the article in the tuple of the database
     * @return ID from the current Article ID
     */
    int getId(String articleId);

    /**
     * Returns the ID associated with the given ID (Primary Key)
     * @param ID - INTEGER ID (Primary Key) for a tuple in the database
     * @return ID associated with the given ID (Primary Key)
     */
    String getArticleId(int ID);

    /**
     * Returns the initialization time for the Article ID provided through this method's argument.
     * The initilzation time can be one of the following format, given the class type. Following are the valid class types:
     * <ul>
     * <li>String.class -> Providing this type will return a pretty formatted time in form of a String</li>
     * <li>ArticleTimes.class -> Providing this type will return an instance of ArticleTime class containing read-only 
     * date and time values.</li>
     * </ul>
     * @param <T> T
     * @param type - String.class
     * @param type - ArticleTimes.class
     * @param articleId - Unique string representing the article in the tuple of the database
     * @return Date and Time formatted in the type provided in the method argument
     */
    <T> T getInitTime(Class<?> type, String articleId);

    /**
     * Returns the session start time. A session is a period.
     * @param <T> T
     * @param type - String.class OR ArticleTimes.class
     * @param articleId - Unique string representing the article in the tuple of the database
     * @return Date and Time formatted in the type provided in the method argument
     */
    <T> T getStartTime(Class<?> type, String articleId);

    /**
     * Returns the session elapsed time. A session is a period.
     * @param <T> T
     * @param type - String.class OR ArticleTimes.class
     * @param articleId - Unique string representing the article in the tuple of the database
     * @return Date and Time formatted in the type provided in the method argument
     */
    <T> T getSessionElapsedTime(Class<?> type, String articleId);
}
