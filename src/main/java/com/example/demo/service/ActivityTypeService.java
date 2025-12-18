public interface ActivityTypeService {
    ActivityType createType(Long categoryId, ActivityType type);
    List<ActivityType> getTypesByCategory(Long categoryId);
    ActivityType getType(Long id);
}
