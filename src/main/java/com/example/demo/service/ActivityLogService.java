public interface ActivityLogService {
    ActivityLog logActivity(Long userId, Long typeId, ActivityLogRequest request);
    List<ActivityLog> getLogsByUser(Long userId);
    List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end);
    ActivityLog getLog(Long id);
}
